package com.example.entityrelationship.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.entityrelationship.detailsrequest.DetailsResponse;
import com.example.entityrelationship.entity.College;
@Repository
@Component
public interface CollegeRepository extends JpaRepository<College,Integer>
{
	@Query("SELECT new com.example.entityrelationship.detailsrequest.DetailsResponse(c.cname,s.sname) FROM College c JOIN c.students s")
	public List<DetailsResponse> getDetails();
	
	
	

}
