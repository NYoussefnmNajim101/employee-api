package com.example.employee.services;

import com.example.employee.entities.Employee;
import com.example.employee.model.EmployeeModel;
import com.example.employee.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeModel createEmployee(EmployeeModel employeeModel) {
        Employee employee = null;
        BeanUtils.copyProperties(employeeModel,employee);
        employeeRepository.save(employee);
        return employeeModel;
    }


    @Override
    public Employee saveEmployee(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @Override
    public List<Employee> fetchAllEmployees() {
        return this.employeeRepository.findAll();
    }

    @Override
    public boolean deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id).get();
        employeeRepository.delete(employee);
        return true;
    }

    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);

        return employee;
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        Employee updatedEmployee = employeeRepository.findById(id).get();
        updatedEmployee.setEmail(employee.getEmail());
        updatedEmployee.setFirstName(employee.getFirstName());
        updatedEmployee.setLastName(employee.getLastName());
        employeeRepository.save(updatedEmployee);
        return updatedEmployee;
    }
}
