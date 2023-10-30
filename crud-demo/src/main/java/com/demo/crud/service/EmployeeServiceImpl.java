package com.demo.crud.service;

import com.demo.crud.entity.Department;
import com.demo.crud.entity.Employee;
import com.demo.crud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
//        employee.setDepartment(employee.getDepartment());
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> fetchEmployeeList() {

        List<Employee> empList = employeeRepository.findAll();
        return empList;
    }

    @Override
    public Employee fetchEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId).get();
    }

    @Override
    public Employee updateEmployee(Long employeeId, Employee employee) {
        Employee emp = employeeRepository.findById(employeeId).get();
        if (Objects.nonNull(employee.getEmployeeName()) && !"".equalsIgnoreCase(employee.getEmployeeName())) {
            emp.setEmployeeName(employee.getEmployeeName());
        }
        if (Objects.nonNull(employee.getEmployeeEmail()) && !"".equalsIgnoreCase(employee.getEmployeeEmail())) {
            emp.setEmployeeEmail(employee.getEmployeeEmail());
        }
        if (Objects.nonNull(employee.getEmployeeContact()) && !"".equalsIgnoreCase(employee.getEmployeeContact())) {
            emp.setEmployeeContact(employee.getEmployeeContact());
        }
        return employeeRepository.save(emp);
    }

    @Override
    public void deleteEmployeeById(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}
