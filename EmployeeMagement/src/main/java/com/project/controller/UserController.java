package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.UserInfo;
import com.project.service.UserService;



@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/new")
	public String addNewUser(@RequestBody UserInfo userInfo)
	{
		return userService.addUser(userInfo);
	}
	//@GetMapping("/loggedIn")
	//@PreAuthorize("hasAuthority('ROLE_USER')")
//    public void login(@RequestParam String username, @RequestParam String password) {
//        // Authenticate user
//        // ...
//		System.out.println("login successful");
//        // Update last login time
//       userService.updateLastLoginTime(username);
//        // Return response
//        // ...
//}
}
