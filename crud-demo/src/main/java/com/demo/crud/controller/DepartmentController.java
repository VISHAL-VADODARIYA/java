package com.demo.crud.controller;

import com.demo.crud.converter.DepartmentConverter;
import com.demo.crud.dto.DepartmentDTO;
import com.demo.crud.entity.Department;
import com.demo.crud.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentConverter converter;
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/departments")
    public DepartmentDTO saveDepartment(@RequestBody DepartmentDTO department) {
        Department save = converter.dtoToEntity(department);
        Department saveDepartment = departmentService.saveDepartment(save);
        return converter.entityToDto(saveDepartment);
    }

    @GetMapping("/departments")
    public List<DepartmentDTO> fetchDepartmentList() {
        List<Department> fetchDepartmentList =  departmentService.fetchDepartmentList();
        return converter.entityToDto(fetchDepartmentList);
    }

    @GetMapping("/departments/{id}")
    public DepartmentDTO fetchDepartmentById(@PathVariable("id") Long departmentId) {

        Department fetchDepartmentById = departmentService.fetchDepartmentById(departmentId);
        return converter.entityToDto(fetchDepartmentById);

    }

    @PutMapping("/departments/{id}")
    public DepartmentDTO updateDepartment(@PathVariable("id") Long departmentId, @RequestBody DepartmentDTO department) {

        Department update = converter.dtoToEntity(department);
        Department updateDepartment = departmentService.updateDepartment(departmentId, update);

        return converter.entityToDto(updateDepartment);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
        departmentService.deleteDepartmentById(departmentId);
        return "Department Deleted Successfully!!";
    }


}
