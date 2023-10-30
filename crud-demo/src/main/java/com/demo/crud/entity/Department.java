package com.demo.crud.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;

    @Column(unique = true)
    private String departmentName;

    @OneToMany(mappedBy = "department")
//    @JsonIgnore
    private List<Employee> employees;

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

//    public Employee getEmployeeName() {
//        return employeeName;
//    }
//
//    public void setEmployeeName(Employee employeeName) {
//        this.employeeName = employeeName;
//    }

    public Department(Long departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
//        this.employeeName = employeeName;
    }

    public Department() {
    }

//    @Override
//    public String toString() {
//        return "Department{" +
//                "departmentId=" + departmentId +
//                ", departmentName='" + departmentName +
//                '}';
//    }
}
