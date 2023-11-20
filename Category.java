package com.tech.library.model;

import java.sql.*;

public class Category {

	private int cId;
	private String cName;
	private Timestamp cDate;
	private String status;
	private boolean active=false;
	public Category(String cName, String status ,boolean active) {
		super();
		this.cName = cName;
		this.status = status;
		this.active=active;
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public Timestamp getcDate() {
		return cDate;
	}
	public void setcDate(Timestamp cDate) {
		this.cDate = cDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(int cId, String cName, Timestamp cDate ,String status,boolean active) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.cDate = cDate;
		this.status=status;
		this.active=active;
	}
	public Category(String cName, Timestamp cDate,String status) {
		super();
		this.cName = cName;
		this.cDate = cDate;
		this.status=status;
		this.active=active;
	}

}
