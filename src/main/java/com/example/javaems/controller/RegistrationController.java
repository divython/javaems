package com.example.javaems.controller;
import org.springframework.validation.BindingResult;
import jakarta.validation.Valid;

import com.example.javaems.model.User;
import com.example.javaems.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
    if (result.hasErrors()) {
        return "register";
    }
    if (userRepository.findByUsername(user.getUsername()) != null) {
        model.addAttribute("usernameExists", true);
        return "register";
    }
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    userRepository.save(user);
    return "redirect:/register?success";
}
}
