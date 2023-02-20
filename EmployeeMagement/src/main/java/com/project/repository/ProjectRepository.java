package com.project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.model.Employee;
import com.project.model.Project_Info;

public interface ProjectRepository extends JpaRepository<Project_Info, Integer>{

	//Project_Info findbyname(String project_name);
	 @Query(value="SELECT project_name FROM project_info e WHERE e.project_name = :projectName",nativeQuery = true)
	 Project_Info findByProjectName(@Param("projectName") String projectName);

	//List<Project_Info> findAll(List<Project_Info> projects);
	
	//Project_Info findByProjectName(String project_name);

	//Optional<Employee> findAll(List<Project_Info> projects);

}
