package com.demo.crud.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @NotEmpty
    private String employeeName;

    private String employeeEmail;

    @Pattern(regexp = "^\\d{10}$", message = "Mobile number must be 10 digits")
    private String employeeContact;


    @ManyToOne
//    @JsonIgnore
    @JoinColumn(name = "department_id") // This sets up the foreign key relationship
    private Department department;

    @OneToMany(mappedBy = "employee")
//    @JsonIgnore
    private List<Task> tasks = new ArrayList<>();


    @ManyToMany
//    @JsonIgnore
    @JoinTable(name = "employee_asset",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "asset_id"))
    private List<Asset> assets = new ArrayList<>();

    private int noOfAssets ;

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeContact() {
        return employeeContact;
    }

    public void setEmployeeContact(String employeeContact) {
        this.employeeContact = employeeContact;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Asset> getAssets() {
        return assets;
    }

    public void setAssets(List<Asset> assets) {
        this.assets = assets;
    }

    public int getNoOfAssets() {
        return noOfAssets;
    }

    public void setNoOfAssets(int noOfAssets) {
        this.noOfAssets = noOfAssets;
    }

//    @Override
//    public String toString() {
//        return "Employee{" +
//                "employeeId=" + employeeId +
//                ", employeeName='" + employeeName + '\'' +
//                ", employeeEmail='" + employeeEmail + '\'' +
//                ", employeeContact='" + employeeContact + '\'' +
//                ", department=" + department +
//                ", tasks=" + tasks +
//                ", assets=" + assets +
//                ", noOfAssets=" + noOfAssets +
//                '}';
//    }
}
