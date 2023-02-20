package com.project.controller;

import java.net.URI;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.DailyTaskTracker;
import com.project.model.Employee;
import com.project.model.UserInfo;
import com.project.repository.DepartmentRepository;
import com.project.repository.UserInfoRepository;
import com.project.service.DetailsService;
import com.project.service.UserService;

@RestController
public class DetailsController {

	@Autowired
	private UserInfoRepository userInfoRepository;
	@Autowired
	private DetailsService detailsService;
	private int employeeid;

	public int getEmployeeid() {
		return employeeid;
	}

	
	@PostMapping("/addetails")
	//@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		Employee savedEmployee = detailsService.saveDetails(employee);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
	}

	@GetMapping("/getdetail")
	
	public List<Employee> getAllDetails() {

		Date date = new Date();

		DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss a");
		String formattedDate = dateFormat.format(date);
		String loginTime = formattedDate;
		System.out.println(formattedDate);

		return detailsService.getAllDetails();
	}

	@PreAuthorize("hasAuthority('ROLE_USER')")
	@GetMapping("/employeebyid/{id}")

	public Employee findEmployeeById(@PathVariable int id) {

		employeeid = id;
		return detailsService.getById(id);
	}

	@PutMapping("/updateNumberOfEmployees")
	public void updateNumberOfEmployees() {
		detailsService.updateNumberOfEmployees();
	}
}
