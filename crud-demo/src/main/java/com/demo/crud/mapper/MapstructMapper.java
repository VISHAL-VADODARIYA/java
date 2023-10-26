package com.demo.crud.mapper;

import com.demo.crud.dto.EmployeeDTO;
import com.demo.crud.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface MapstructMapper {
//    @Mapping(source = "",target = "") // need to write when source and target have different name of field
    Employee dtoToEntity(EmployeeDTO dto);
    List<Employee> dtoToEntityList(List<EmployeeDTO> dto);
    EmployeeDTO entityToDto(Employee employee);
    List<EmployeeDTO> entityToDtoList(List<Employee> employee);

}
