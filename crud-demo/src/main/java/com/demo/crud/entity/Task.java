package com.demo.crud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long taskId;

    private String taskName;

    private boolean assigned;

    @ManyToOne
    @JoinColumn(name = "employee_id") // This sets up the foreign key relationship
    private Employee employee;
//    private Long employeeId;


}
