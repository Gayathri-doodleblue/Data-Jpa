package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.project.model.Department_Info;
import com.project.model.Employee;
@Repository

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	//Employee findByEmployee_Id(int employee_id);

	//Employee findById(int id);

//	int countByDepartment(Department_Info department);
//	List<Employee> findByDepartmentId(int i);
//
//	Long countByDepartmentId(Long departmentId);
	
//	@Modifying
//	@Query(value="insert into employeemanagement.employee(employee_id,address,blood_group,contact_number,designation,employee_name,salary,department_id) values(?,?,?,?,?,?,?,?)",nativeQuery = true)
//	    void updateClientName();
	

}
