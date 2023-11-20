package com.tech.library.model;


import java.sql.*;
public class User {
	
	private int id;
	private String name;
	private String email;
	private String pass;
	private Long phone;
	private Timestamp dateTime;
	private String profile;
	private String userType;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long string) {
		this.phone = string;
	}
	public Timestamp getDateTime() {
		return dateTime;
	}
	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public User(int id, String name, String email, String pass, Long phone, Timestamp dateTime,String userType) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.pass = pass;
		this.phone = phone;
		this.dateTime = dateTime;
		this.userType=userType;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String name, String email, String pass, Long phone, Timestamp dateTime) {
		super();
		this.name = name;
		this.email = email;
		this.pass = pass;
		this.phone = phone;
		this.dateTime = dateTime;
		
	}
	public User(String name, String email, String pass, Long phone) {
		super();
		this.name = name;
		this.email = email;
		this.pass = pass;
		this.phone = phone;
	}
	
	
	
}
