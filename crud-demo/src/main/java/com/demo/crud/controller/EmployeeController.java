package com.demo.crud.controller;


import com.demo.crud.converter.EmployeeConverter;
import com.demo.crud.dto.DepartmentDTO;
import com.demo.crud.dto.EmployeeDTO;
import com.demo.crud.entity.Department;
import com.demo.crud.entity.Employee;
import com.demo.crud.mapper.MapstructMapper;
import com.demo.crud.service.DepartmentService;
import com.demo.crud.service.EmployeeService;
import org.apache.coyote.Response;
import org.mapstruct.factory.Mappers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
        employee.setDepartment(dep);

//        Employee save = converter.dtoToEntity(employee); // using manully DTO object
//        Employee save = modelMapper.map(employee,Employee.class); // using ModelMapper
        Employee save = mapper.dtoToEntity(employee); // using MapStruct Mapper

        System.out.println(employee);

        Employee saveEmployee = employeeService.saveEmployee(save);

//        return modelMapper.map(saveEmployee,EmployeeDTO.class);  // using manully DTO object
//        return modelMapper.map(saveEmployee,EmployeeDTO.class); // using ModelMapper
        return mapper.entityToDto(saveEmployee); // using MapStruct mapper
    }

    @GetMapping("/employees")
    public List<EmployeeDTO> fetchEmployeeList() {
        List<Employee> fetchEmployeeList = employeeService.fetchEmployeeList();
        List<EmployeeDTO> listWithGroup = new List<EmployeeDTO>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<EmployeeDTO> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(EmployeeDTO dto) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends EmployeeDTO> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends EmployeeDTO> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public EmployeeDTO get(int index) {
                return null;
            }

            @Override
            public EmployeeDTO set(int index, EmployeeDTO element) {
                return null;
            }

            @Override
            public void add(int index, EmployeeDTO element) {

            }

            @Override
            public EmployeeDTO remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<EmployeeDTO> listIterator() {
                return null;
            }

            @Override
            public ListIterator<EmployeeDTO> listIterator(int index) {
                return null;
            }

            @Override
            public List<EmployeeDTO> subList(int fromIndex, int toIndex) {
                return null;
            }
        };

        List list = mapper.entityToDtoList(fetchEmployeeList);
        for (int i = 0; i < list.size(); i++) {
            Object demo = list.get(i);
            if ()
//            String item = list.get(i);
                System.out.println("Item at index " + i + ": " + demo);
        }
       

//        return converter.entityToDto(fetchEmployeeList);  // using manully DTO object
//        return Arrays.asList(modelMapper.map(fetchEmployeeList,EmployeeDTO[].class));  // using ModelMapper
        return mapper.entityToDtoList(fetchEmployeeList); // using MapStruct mapper
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
