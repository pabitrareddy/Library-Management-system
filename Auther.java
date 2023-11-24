package com.tech.library.model;

import java.sql.*;

public class Auther {
	
	private int aID;
	private String aName;
	private Timestamp aDate;
	
	public int getaID() {
		return aID;
	}
	public void setaID(int aID) {
		this.aID = aID;
	}
	public String getaName() {
		return aName;
	}
	public void setaName(String aName) {
		this.aName = aName;
	}
	public Timestamp getaDate() {
		return aDate;
	}
	public void setaDate(Timestamp aDate) {
		this.aDate = aDate;
	}
	
	public Auther() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Auther(int aID, String aName, Timestamp aDate) {
		super();
		this.aID = aID;
		this.aName = aName;
		this.aDate = aDate;
	}
	public Auther(String aName, Timestamp aDate) {
		super();
		this.aName = aName;
		this.aDate = aDate;
	}

	
}
