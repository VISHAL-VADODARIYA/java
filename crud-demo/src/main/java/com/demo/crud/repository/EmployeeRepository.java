package com.demo.crud.repository;


import com.demo.crud.entity.Department;
import com.demo.crud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee,Long> {

//    @Query("SELECT ")
//    List<Employee> getNameAndDepartment(@Param("department")Department department);
}
