package com.example.entityrelationship.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.emp.customexception.ControllerException;
//import com.example.emp.customexception.ControllerException;
//import com.example.emp.model.Employee;
//import com.example.emp.controller.EmployeeController;
import com.example.entityrelationship.detailsrequest.DetailsRequest;
import com.example.entityrelationship.detailsrequest.DetailsResponse;
import com.example.entityrelationship.entity.College;
import com.example.entityrelationship.respository.CollegeRepository;
import com.example.entityrelationship.respository.StudentRepository;

@RestController
public class CollegeStudentController {
	Logger logger = LoggerFactory.getLogger(CollegeStudentController.class);
	
	@Autowired
	private CollegeRepository collegeRepository;
	
	@Autowired 
	private StudentRepository studentRepository;
	
	@PostMapping("/all")
	public ResponseEntity<?>  allDetails(@RequestBody DetailsRequest request)
	{
		try {
		logger.info("Add  college and student details");
		College college= collegeRepository.save(request.getCollege());
		return new ResponseEntity<College>(college, HttpStatus.CREATED);
	}
		catch (Exception e) {
			ControllerException ce = new ControllerException("606", "error");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/getallvalues")
	public List<College> getalldetails()
	{
		logger.info("get  college and student details");
		return collegeRepository.findAll();
	}
	@GetMapping("/getvalues")
	public List<DetailsResponse> getDetails()
	{
		logger.info("get  collegename and studentname details");
		return collegeRepository.getDetails();
	}
}
