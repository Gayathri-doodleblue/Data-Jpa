package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.model.DailyTaskTracker;
import com.project.repository.DailyTaskRepository;

import jakarta.transaction.Transactional;

@Service
public class DailyTaskService {
	
	
	
	@Autowired
	private DailyTaskRepository dailyTaskRepository;
	public DailyTaskTracker addDetails(@RequestBody DailyTaskTracker dailyTaskTracker)
	{
	
		double hoursWorked = dailyTaskTracker.getHoursWorked();
	    dailyTaskTracker.setHours_worked(hoursWorked);
		return dailyTaskRepository.save(dailyTaskTracker);	}
	
	@Transactional
    public void updateProjectName() {
       dailyTaskRepository.updateProjectName();
       
    }
	

	@Transactional
    public void updateClientName() {
       dailyTaskRepository.updateClientName();
       
    }
	@Transactional
    public void updateEmloyeeName() {
       dailyTaskRepository.updateEmployeeName();
       
    }
	

}
