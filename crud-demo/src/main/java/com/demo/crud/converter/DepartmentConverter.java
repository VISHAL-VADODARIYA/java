package com.demo.crud.converter;

import com.demo.crud.dto.DepartmentDTO;
import com.demo.crud.entity.Department;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DepartmentConverter {

    public DepartmentDTO entityToDto(Department department){
        DepartmentDTO dto = new DepartmentDTO();
        dto.setDepartmentId(department.getDepartmentId());
        dto.setDepartmentName(department.getDepartmentName());
        return dto;
    }

    public List<DepartmentDTO> entityToDto(List<Department> department){
        return department.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
    }

    public Department dtoToEntity(DepartmentDTO dto){
        Department dep = new Department();
        dep.setDepartmentName(dto.getDepartmentName());
        dep.setDepartmentId(dto.getDepartmentId());

        return dep;
    }
    public List<Department> dtoToEntity(List<DepartmentDTO> dto){

        return dto.stream().map( x -> dtoToEntity(x)).collect(Collectors.toList());
    }

}
