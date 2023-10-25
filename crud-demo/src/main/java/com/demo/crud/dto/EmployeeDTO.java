package com.demo.crud.dto;

import com.demo.crud.entity.Department;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;


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

}
