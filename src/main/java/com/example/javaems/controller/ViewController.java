// package com.example.javaems.controller;

// // import com.example.javaems.model.Employee;
// import com.example.javaems.service.EmployeeService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;

// // import java.util.List;

// @Controller
// public class ViewController {

//     @Autowired
//     private EmployeeService employeeService;

//     @GetMapping("/employees-ui")
//     public String listEmployees(Model model) {
//         model.addAttribute("employees", employeeService.getAllEmployees());
//         return "employees"; // this must match the Thymeleaf template file
//     }
// }


