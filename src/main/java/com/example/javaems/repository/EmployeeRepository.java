package com.example.javaems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.javaems.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {}
