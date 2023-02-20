package com.project.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.model.DailyTaskTracker;
import com.project.model.UserInfo;
import com.project.repository.DailyTaskRepository;
import com.project.repository.UserInfoRepository;



@Service
public class UserService {
	@Autowired
	private UserInfoRepository userInfoRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	 @Autowired
	    private DailyTaskRepository dailyTaskRepository;
	 public String addUser(UserInfo userinfo)
	   {
		 
		   userinfo.setPassword(passwordEncoder.encode(userinfo.getPassword()));
		  userInfoRepository.save(userinfo);
		  return "user added to System";
	   }
	 
//	 public void updateLastLoginTime(String username) {
//		 System.out.println("Present");
//		 UserInfo userinfo= userInfoRepository.findByName(username);
//		 DailyTaskTracker userLogin = new DailyTaskTracker();
//	        userLogin.setUser(userinfo);
//	        userLogin.setLoginTime(LocalDateTime.now());
//	        dailyTaskRepository.save(userLogin);
//	    }

}
