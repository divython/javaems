// package com.example.javaems.controller;

// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.GetMapping;

// import jakarta.servlet.http.HttpServletResponse;
// import java.io.IOException;

// @Controller
// public class LoginRedirectController {

//     @GetMapping("/redirect-after-login")
//     public void redirectAfterLogin(Authentication authentication, HttpServletResponse response) throws IOException {
//         if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
//             response.sendRedirect("/employees-ui");
//         } else if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_USER"))) {
//             response.sendRedirect("/ping");
//         } else {
//             response.sendRedirect("/access-denied");
//         }
//     }
// }


