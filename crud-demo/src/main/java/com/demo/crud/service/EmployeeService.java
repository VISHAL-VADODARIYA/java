package com.demo.crud.service;

import com.demo.crud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EmployeeService {
    public Employee saveEmployee(Employee employee);

    public List<Employee> fetchEmployeeList();

    public Employee fetchEmployeeById(Long employeeId);

    public Employee updateEmployee(Long employeeId, Employee employee);

    public void deleteEmployeeById(Long employeeId);
}
