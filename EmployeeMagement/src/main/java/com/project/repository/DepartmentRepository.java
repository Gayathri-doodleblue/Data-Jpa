package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.project.model.Department_Info;
import com.project.model.Employee;

@Repository
public interface DepartmentRepository extends JpaRepository<Department_Info,String> {

//	Department_Info findByDepartment_name(String departmentName);
    @Modifying
    @Query(value="UPDATE department_info d SET total_employee = ( SELECT COUNT(*)FROM employee e WHERE e.designation = d.department_name)",nativeQuery = true)
    void updateNumberOfEmployees();

//    List<Employee> findByDepartmentId(Long departmentId);
	
}
