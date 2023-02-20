package com.project.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.DailyTaskTracker;
import com.project.model.Department_Info;
import com.project.model.Employee;
import com.project.model.UserInfo;
import com.project.repository.DailyTaskRepository;
import com.project.repository.DepartmentRepository;
import com.project.repository.EmployeeRepository;
import com.project.repository.UserInfoRepository;

import jakarta.transaction.Transactional;

@Service
public class DetailsService
{
	@Autowired
	private UserInfoRepository userInfoRepository;
	
	
	
	 @Autowired
	    private DailyTaskRepository dailyTaskRepository;

	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Transactional
	//@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public Employee saveDetails(@RequestBody Employee employee)
	{		
		return employeeRepository.save(employee);
	}
	
	@Transactional
    public void updateNumberOfEmployees() {
        departmentRepository.updateNumberOfEmployees();
    }

	public List<Employee> getAllDetails()
	{
		return employeeRepository.findAll();
	}

	public Employee getById(int id)
	{
		return employeeRepository.findById(id).orElse(null);
	}
}
	 



