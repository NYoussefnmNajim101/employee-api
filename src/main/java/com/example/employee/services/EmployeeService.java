package com.example.employee.services;

import com.example.employee.entities.Employee;
import com.example.employee.model.EmployeeModel;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    EmployeeModel createEmployee(EmployeeModel employeeModel);

    Employee saveEmployee(Employee employee);

    List<Employee> fetchAllEmployees();

    boolean deleteEmployee(Long id);

    Optional<Employee> getEmployeeById(Long id);

    Employee updateEmployee(Long id, Employee employee);
}
