package com.example.javaems.controller;

import com.example.javaems.model.Employee;
import com.example.javaems.service.EmployeeService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

import java.io.IOException;

import java.time.LocalDateTime;
import org.springframework.security.core.Authentication;

//import org.springframework.security.core.Authentication;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.javaems.repository.UserRepository;
import com.example.javaems.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;

//import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeUIController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees-ui")
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "employees";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "add-employee";
    }

@PostMapping("/save")
public String saveEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult result, Model model, Authentication authentication, RedirectAttributes redirectAttributes) {
    if (result.hasErrors()) {
        return "add-employee";
    }
    employee.setCreatedBy(authentication.getName());
    employee.setCreatedAt(LocalDateTime.now());
    employee.setUpdatedBy(authentication.getName());
    employee.setUpdatedAt(LocalDateTime.now());
    employeeService.save(employee);
    redirectAttributes.addFlashAttribute("success", "Employee added successfully!");
    return "redirect:/employees-ui";
}

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "edit-employee";
    }

    @PostMapping("/update")
public String updateEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult result, Model model, Authentication authentication) {
    if (result.hasErrors()) {
        return "edit-employee";
    }
    Employee existing = employeeService.getEmployeeById(employee.getId());
    employee.setCreatedBy(existing.getCreatedBy());
    employee.setCreatedAt(existing.getCreatedAt());
    employee.setUpdatedBy(authentication.getName());
    employee.setUpdatedAt(LocalDateTime.now());
    employeeService.save(employee);
    return "redirect:/employees-ui";
}

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employees-ui";
    }

    @GetMapping("/")
    public String home() {
    return "redirect:/employees-ui";
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // this should match your login template
    }  
    
    @GetMapping("/access-denied")
    public String accessDenied() {
    return "access-denied";
    }

    @GetMapping("/redirect-after-login")
    public void redirectAfterLogin(Authentication authentication, HttpServletResponse response) throws IOException {
        if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
            response.sendRedirect("/employees-ui");
        } else if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_USER"))) {
            response.sendRedirect("/ping");
        } else {
            response.sendRedirect("/access-denied");
        }
    }

    @GetMapping("/ping")
public String userHome(Model model, Authentication authentication) {
    model.addAttribute("username", authentication.getName());
    return "user-home";
    }

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/profile")
    public String viewProfile(Model model, Authentication authentication) {
    String username = authentication.getName();
    User user = userRepository.findByUsername(username);
    model.addAttribute("user", user);
    return "profile";
    }

    @PostMapping("/profile")
    public String updateProfile(@ModelAttribute("user") User user, BindingResult result, Model model, Authentication authentication) {
    if (result.hasErrors()) {
        return "profile";
    }
    User existingUser = userRepository.findByUsername(authentication.getName());
    existingUser.setEmail(user.getEmail());
    if (user.getPassword() != null && !user.getPassword().isEmpty()) {
        existingUser.setPassword(passwordEncoder.encode(user.getPassword()));
    }
    userRepository.save(existingUser);
    model.addAttribute("user", existingUser);
    model.addAttribute("success", true);
    return "profile";
    }


}
