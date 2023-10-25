package com.demo.crud.dto;

import com.demo.crud.entity.Employee;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {

    private Long departmentId;

    private String departmentName;

}
