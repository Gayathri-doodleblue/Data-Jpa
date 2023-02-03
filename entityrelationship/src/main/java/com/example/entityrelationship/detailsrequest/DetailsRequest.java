package com.example.entityrelationship.detailsrequest;

import com.example.entityrelationship.entity.College;

public class DetailsRequest {
	private College college;
	public DetailsRequest()
	{
		
	}

	public DetailsRequest(College college) {
		super();
		this.college = college;
	}

	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}
	

}
