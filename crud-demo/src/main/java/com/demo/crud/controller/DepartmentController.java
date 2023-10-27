package com.demo.crud.controller;

import com.demo.crud.converter.DepartmentConverter;
import com.demo.crud.dto.DepartmentDTO;
import com.demo.crud.entity.Department;
import com.demo.crud.mapper.MapstructMapperDep;
import com.demo.crud.service.DepartmentService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentConverter converter;

    @Autowired
    private DepartmentService departmentService;

    MapstructMapperDep mapper = Mappers.getMapper(MapstructMapperDep.class);

    @PostMapping("/departments")
    public DepartmentDTO saveDepartment(@RequestBody DepartmentDTO department) {

//        Department save = converter.dtoToEntity(department);
        Department save = mapper.dtoToEntity(department);
        Department saveDepartment = departmentService.saveDepartment(save);

//        return converter.entityToDto(saveDepartment);
        return mapper.entityToDto(saveDepartment);
    }

    @GetMapping("/departments")
    public List<DepartmentDTO> fetchDepartmentList() {
        List<Department> fetchDepartmentList =  departmentService.fetchDepartmentList();
//        return converter.entityToDto(fetchDepartmentList);
        return mapper.entityToDtoList(fetchDepartmentList);
    }

    @GetMapping("/departments/{id}")
    public DepartmentDTO fetchDepartmentById(@PathVariable("id") Long departmentId) {

        Department fetchDepartmentById = departmentService.fetchDepartmentById(departmentId);
//        return converter.entityToDto(fetchDepartmentById);
        return mapper.entityToDto(fetchDepartmentById);

    }

    @PutMapping("/departments/{id}")
    public DepartmentDTO updateDepartment(@PathVariable("id") Long departmentId, @RequestBody DepartmentDTO department) {

//        Department update = converter.dtoToEntity(department);
        Department update = mapper.dtoToEntity(department);
        Department updateDepartment = departmentService.updateDepartment(departmentId, update);

//        return converter.entityToDto(updateDepartment);
        return mapper.entityToDto(updateDepartment);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
        departmentService.deleteDepartmentById(departmentId);
        return "Department Deleted Successfully!!";
    }


}
