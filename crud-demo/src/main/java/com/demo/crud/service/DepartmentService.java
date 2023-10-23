package com.demo.crud.service;

import com.demo.crud.entity.Department;
import com.demo.crud.entity.Employee;

import java.util.List;


public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public void deleteDepartmentById(Long departmentId);

    public Department updateDepartment(Long departmentId, Department department);

    public Department fetchDepartmentById(Long departmentId);
}
