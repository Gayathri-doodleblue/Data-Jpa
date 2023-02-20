package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.DailyTaskTracker;
import com.project.service.DailyTaskService;

@RestController
public class DailyTaskController {
	
	
	@Autowired
	private DailyTaskService dailyTaskService;
	
	@PostMapping("/eoddetails")
	public DailyTaskTracker saveDetails(@RequestBody DailyTaskTracker dailyTaskTracker)
	{
		return dailyTaskService.addDetails(dailyTaskTracker);
	}
	
	@PutMapping("/updateProject")
    public void updateProject() {
        dailyTaskService.updateProjectName();
        
        dailyTaskService.updateClientName();
        dailyTaskService.updateEmloyeeName();
    }

}
