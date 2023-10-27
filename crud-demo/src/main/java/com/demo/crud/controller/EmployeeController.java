package com.demo.crud.controller;


import com.demo.crud.converter.EmployeeConverter;
import com.demo.crud.dto.DepartmentDTO;
import com.demo.crud.dto.EmployeeDTO;
import com.demo.crud.entity.Department;
import com.demo.crud.entity.Employee;
import com.demo.crud.mapper.MapstructMapper;
import com.demo.crud.response.ApiResponse;
import com.demo.crud.response.StringResponse;
import com.demo.crud.service.DepartmentService;
import com.demo.crud.service.EmployeeService;
import org.apache.coyote.Response;
import org.mapstruct.factory.Mappers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private EmployeeConverter converter;

    MapstructMapper mapper = Mappers.getMapper(MapstructMapper.class);


    @PostMapping("/employees")
    public EmployeeDTO saveEmployee(@RequestBody EmployeeDTO employee) {
// call service for long by id
        Department dep = departmentService.fetchDepartmentById(employee.getDepartment().getDepartmentId());
        //        if (dep.getDepartmentId() != employee.getDepartment().getDepartmentId()){
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new StringResponse("could not find department with this id"));
//        }
        employee.setDepartment(dep);

//        Employee save = converter.dtoToEntity(employee); // using manully DTO object
//        Employee save = modelMapper.map(employee,Employee.class); // using ModelMapper
        Employee save = mapper.dtoToEntity(employee); // using MapStruct Mapper

        System.out.println(employee);

        Employee saveEmployee = employeeService.saveEmployee(save);

//        return modelMapper.map(saveEmployee,EmployeeDTO.class);  // using manully DTO object
//        return modelMapper.map(saveEmployee,EmployeeDTO.class); // using ModelMapper
        return mapper.entityToDto(saveEmployee);
    }

    @PostMapping("/departments/employees")
    public List<EmployeeDTO> fetchEmployeeListByDepName(@RequestBody DepartmentDTO department) {
        List<Employee> listWithDepName = new ArrayList<>();

        List<Employee> fetchEmployeeList = employeeService.fetchEmployeeList();
        System.out.println(department.getDepartmentName());
        fetchEmployeeList.forEach(o -> {
            if (o.getDepartment().getDepartmentName().equals(department.getDepartmentName())) {
                listWithDepName.add(o);
            }
        });


        return mapper.entityToDtoList(listWithDepName);
    }

    @GetMapping("/employees")
    public List<EmployeeDTO> fetchEmployeeList() {
        List<Employee> fetchEmployeeList = employeeService.fetchEmployeeList();
        List<EmployeeDTO> listWithGroup = new ArrayList<>();

        List<EmployeeDTO> list = mapper.entityToDtoList(fetchEmployeeList);
        List<Department> depList = departmentService.fetchDepartmentList();
        depList.forEach(d -> {
            list.forEach(o -> {
                if (d.getDepartmentName() == o.getDepartment().getDepartmentName()) {
                    listWithGroup.add(o);
                }
                System.out.println("Item at index " + o + ": " + o.getDepartment().getDepartmentName());
            });
        });

//        return converter.entityToDto(fetchEmployeeList);  // using manully DTO object
//        return Arrays.asList(modelMapper.map(fetchEmployeeList,EmployeeDTO[].class));  // using ModelMapper
//        return mapper.entityToDtoList(fetchEmployeeList); // using MapStruct mapper
        return listWithGroup; // using MapStruct mapper
    }

    @GetMapping("/employees/{id}")
    public EmployeeDTO fetchEmployeeById(@PathVariable("id") Long employeeId) {
        Employee fetchEmployeeById = employeeService.fetchEmployeeById(employeeId);

//        return converter.entityToDto(fetchEmployeeById);
//        return modelMapper.map(fetchEmployeeById,EmployeeDTO.class);
        return mapper.entityToDto(fetchEmployeeById);
    }

    @PutMapping("/employees/{id}")
    public EmployeeDTO updateEmployee(@PathVariable("id") Long employeeId, @RequestBody EmployeeDTO employee) {
//        Employee update = converter.dtoToEntity(employee);
//        Employee update = modelMapper.map(employee,Employee.class);
        Employee update = mapper.dtoToEntity(employee);

        Employee updateEmployee = employeeService.updateEmployee(employeeId, update);

//        return converter.entityToDto(updateEmployee);
//        return modelMapper.map(updateEmployee,EmployeeDTO.class);
        return mapper.entityToDto(updateEmployee);
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployeeById(@PathVariable("id") Long employeeId) {
        employeeService.deleteEmployeeById(employeeId);
        return "Employee Deleted Successfully!!";
    }
}
