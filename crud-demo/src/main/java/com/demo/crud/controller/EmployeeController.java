package com.demo.crud.controller;


import com.demo.crud.converter.EmployeeConverter;
import com.demo.crud.dto.DepartmentDTO;
import com.demo.crud.dto.EmployeeDTO;
import com.demo.crud.entity.Department;
import com.demo.crud.entity.Employee;
import com.demo.crud.service.DepartmentService;
import com.demo.crud.service.EmployeeService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private EmployeeConverter converter;

    @PostMapping("/employees")
    public EmployeeDTO saveEmployee(@RequestBody EmployeeDTO employee) {
// call service for long by idd
        Department dep = departmentService.fetchDepartmentById(employee.getDepartment().getDepartmentId());
        employee.setDepartment(dep);

        Employee save = converter.dtoToEntity(employee);


        Employee saveEmployee = employeeService.saveEmployee(save);

        return converter.entityToDto(saveEmployee);
    }

    @GetMapping("/employees")
    public List<EmployeeDTO> fetchEmployeeList() {
        List<Employee> fetchEmployeeList = employeeService.fetchEmployeeList();
        return converter.entityToDto(fetchEmployeeList);

    }

    @GetMapping("/employees/{id}")
    public EmployeeDTO fetchEmployeeById(@PathVariable("id") Long employeeId) {
        Employee fetchEmployeeById = employeeService.fetchEmployeeById(employeeId);

        return converter.entityToDto(fetchEmployeeById);
    }

    @PutMapping("/employees/{id}")
    public EmployeeDTO updateEmployee(@PathVariable("id") Long employeeId, @RequestBody EmployeeDTO employee) {
        Employee update = converter.dtoToEntity(employee);

        Employee updateEmployee = employeeService.updateEmployee(employeeId, update);

        return converter.entityToDto(updateEmployee);
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployeeById(@PathVariable("id") Long employeeId) {
        employeeService.deleteEmployeeById(employeeId);
        return "Employee Deleted Successfully!!";
    }
}
