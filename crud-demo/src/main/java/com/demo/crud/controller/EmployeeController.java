package com.demo.crud.controller;


import com.demo.crud.converter.EmployeeConverter;
import com.demo.crud.dto.AssetDTO;
import com.demo.crud.dto.DepartmentDTO;
import com.demo.crud.dto.EmployeeDTO;
import com.demo.crud.dto.TaskDTO;
import com.demo.crud.entity.Asset;
import com.demo.crud.entity.Department;
import com.demo.crud.entity.Employee;
import com.demo.crud.entity.Task;
import com.demo.crud.mapper.MapstructMapper;
import com.demo.crud.mapper.MapstructMapperAsset;
import com.demo.crud.response.ApiResponse;
import com.demo.crud.response.StringResponse;
import com.demo.crud.service.AssetService;
import com.demo.crud.service.DepartmentService;
import com.demo.crud.service.EmployeeService;
import com.demo.crud.service.TaskService;
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
    private AssetService assetService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private EmployeeConverter converter;

    MapstructMapper mapper = Mappers.getMapper(MapstructMapper.class);
    MapstructMapperAsset mapAst = Mappers.getMapper(MapstructMapperAsset.class);


    @PostMapping("/employees")
    public EmployeeDTO saveEmployee(@RequestBody EmployeeDTO employee) {
// call service for long by id

        //department
        Department dep = departmentService.fetchDepartmentById(employee.getDepartment().getDepartmentId());
        employee.setDepartment(dep);
        //        if (dep.getDepartmentId() != employee.getDepartment().getDepartmentId()){
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new StringResponse("could not find department with this id"));
//        }

        //assets
        List<Asset> asst = new ArrayList<>();
        List<Asset> assets = employee.getAssets();
        assets.forEach(o -> asst.add(assetService.fetchAssetById(o.getAssetId())));
        employee.setAssets(asst);
//        employee.setNoOfAssets(employee.getAssets().size());

        //task
        List<Task> tk = new ArrayList<>();
        List<Task> tasks = employee.getTasks();
        String name = employee.getEmployeeName();
        tasks.forEach(t -> tk.add(taskService.fetchTaskById(t.getTaskId())));
        employee.setTasks(tk);


        Employee save = mapper.dtoToEntity(employee); // using MapStruct Mapper
        Employee saveEmployee = employeeService.saveEmployee(save);
        EmployeeDTO x = mapper.entityToDto(saveEmployee);
        x.setNoOfAssets(x.getAssets().size());

        return x;
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
