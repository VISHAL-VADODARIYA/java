package com.demo.crud.dto;

import com.demo.crud.entity.Asset;
import com.demo.crud.entity.Department;
import com.demo.crud.entity.Task;
import com.demo.crud.response.ApiResponse;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    private Long employeeId;

    private String employeeName;

    private String employeeEmail;

    private String employeeContact;

//    private Long departmentId;

    private Department department;

    private List<Task> tasks ;

    private List<Asset> assets ;

    private int noOfAssets;
}
