package com.example.entityrelationship.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table
public class Student {
	@Id
	
	private int sid;
	@Column
	private String sname;
	@Column
	private int age;
	public Student()
	{
		
	}
	public Student(int sid, String sname, int age) {
		
		this.sid = sid;
		this.sname = sname;
		this.age = age;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	

}
