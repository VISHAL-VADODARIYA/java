package com.demo.crud.converter;

import com.demo.crud.dto.EmployeeDTO;
import com.demo.crud.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeConverter {
    public EmployeeDTO entityToDto(Employee employee){
        EmployeeDTO dto = new EmployeeDTO();
        dto.setEmployeeId(employee.getEmployeeId());
        dto.setEmployeeName(employee.getEmployeeName());
        dto.setEmployeeEmail(employee.getEmployeeEmail());
        dto.setEmployeeContact(employee.getEmployeeContact());
//      dto.setDepartmentId(employee.getDepartment().getDepartmentId());
        dto.setDepartment(employee.getDepartment());

        return dto;
    }

    public List<EmployeeDTO> entityToDto(List<Employee> employee){
        return employee.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
    }

    public Employee dtoToEntity(EmployeeDTO dto){
        Employee emp = new Employee();
        emp.setEmployeeId(dto.getEmployeeId());
        emp.setEmployeeName(dto.getEmployeeName());
        emp.setEmployeeEmail(dto.getEmployeeEmail());
        emp.setEmployeeContact(dto.getEmployeeContact());
        emp.setDepartment(dto.getDepartment());

        return emp;
    }

    public List<Employee> dtoToEntity(List<EmployeeDTO> dto){

        return dto.stream().map( x -> dtoToEntity(x)).collect(Collectors.toList());
    }

}
