package com.example.javaems.service;

import com.example.javaems.model.Employee;
import com.example.javaems.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    public EmployeeServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllEmployees() {
        Employee emp1 = new Employee();
        emp1.setName("Alice");
        Employee emp2 = new Employee();
        emp2.setName("Bob");

        when(employeeRepository.findAll()).thenReturn(Arrays.asList(emp1, emp2));

        List<Employee> employees = employeeService.getAllEmployees();
        assertEquals(2, employees.size());
        assertEquals("Alice", employees.get(0).getName());
    }

    @Test
    void testSaveEmployee() {
        Employee emp = new Employee();
        emp.setName("Charlie");

        when(employeeRepository.save(emp)).thenReturn(emp);

        Employee saved = employeeService.save(emp);
        assertEquals("Charlie", saved.getName());
        verify(employeeRepository, times(1)).save(emp);
    }
}
