package com.demo.crud.dto;

import com.demo.crud.entity.Department;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTOWithId {

    private Long employeeId;

    private String employeeName;

    private String employeeEmail;

    private String employeeContact;

    private Long departmentId;


}


