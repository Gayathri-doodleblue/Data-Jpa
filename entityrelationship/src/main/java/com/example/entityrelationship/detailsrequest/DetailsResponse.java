package com.example.entityrelationship.detailsrequest;

public class DetailsResponse {
	private String cname;
	private String sname;
	
	public DetailsResponse() {
		super();
	}
	public DetailsResponse(String cname, String sname) {
		super();
		this.cname = cname;
		this.sname = sname;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	
	

}
