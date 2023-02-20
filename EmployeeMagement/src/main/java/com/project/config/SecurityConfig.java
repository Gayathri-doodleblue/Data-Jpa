package com.project.config;




import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.project.controller.DetailsController;
import com.project.model.DailyTaskTracker;
import com.project.model.Employee;
import com.project.model.Project_Info;
import com.project.model.UserInfo;
import com.project.repository.DailyTaskRepository;
import com.project.repository.EmployeeRepository;
import com.project.repository.ProjectRepository;
import com.project.repository.UserInfoRepository;

import io.jsonwebtoken.lang.Collections;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//import com.project.handler.CustomAuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity

@EnableMethodSecurity
public class SecurityConfig {



	@Bean
	public UserDetailsService userDetailsService() {

		return new UserInfoUserDetailsService();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.csrf().disable().authorizeHttpRequests()
				
				.requestMatchers( "/new", "/getdetail", "/updateNumberOfEmployees", "/eoddetails","/updateProject","/addetails")
				.permitAll() 
				.and()
//				.authorizeHttpRequests().requestMatchers(HttpMethod.POST,"/admin")
//				.authenticated().and()
				.authorizeHttpRequests().requestMatchers("/employeebyid/{id}"  ).authenticated()
				.and().formLogin().and().build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService());
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}

}
