package com.demo.crud.mapper;

import com.demo.crud.dto.DepartmentDTO;
import com.demo.crud.entity.Department;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface MapstructMapperDep{
    //    @Mapping(source = "",target = "") // need to write when source and target have different name of field
    Department dtoToEntity(DepartmentDTO dto);
    List<Department> dtoToEntityList(List<DepartmentDTO> dto);
    DepartmentDTO entityToDto(Department employee);
    List<DepartmentDTO> entityToDtoList(List<Department> employee);

}

