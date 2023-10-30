package com.demo.crud.dto;

import com.demo.crud.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO {

    private  Long taskId;

    private String taskName;

    private Employee employee;

}
