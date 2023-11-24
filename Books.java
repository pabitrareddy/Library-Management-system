package com.tech.library.model;

import java.sql.*;

public class Books {

	
	private int bID;
	private String bName;
	private int bISBN;
	private Double bPrice;
	private Timestamp bDate;
	private int catID;
	private String autID;
	private String pics;
	public int getbID() {
		return bID;
	}
	public void setbID(int bID) {
		this.bID = bID;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public int getbISBN() {
		return bISBN;
	}
	public void setbISBN(int bISBN) {
		this.bISBN = bISBN;
	}
	public Double getbPrice() {
		return bPrice;
	}
	public void setbPrice(Double bPrice) {
		this.bPrice = bPrice;
	}
	public Timestamp getbDate() {
		return bDate;
	}
	public void setbDate(Timestamp bDate) {
		this.bDate = bDate;
	}
	public int getCatID() {
		return catID;
	}
	public void setCatID(int catID) {
		this.catID = catID;
	}
	public String getAutID() {
		return autID;
	}
	public void setAutID(String autID) {
		this.autID = autID;
	}
	public String getPics() {
		return pics;
	}
	public void setPics(String pics) {
		this.pics = pics;
	}
	public Books(String bName, int bISBN, Double bPrice, Timestamp bDate, int catID,String autID,String pics ) {
		super();
		this.bName = bName;
		this.bISBN = bISBN;
		this.bPrice = bPrice;
		this.bDate = bDate;
		this.catID = catID;
		this.autID=autID;
		this.pics=pics;
	}
	public Books(int bID, String bName, int bISBN, Double bPrice, Timestamp bDate, int catID,String autID ,String pics ) {
		super();
		this.bID = bID;
		this.bName = bName;
		this.bISBN = bISBN;
		this.bPrice = bPrice;
		this.bDate = bDate;
		this.catID = catID;
		this.autID=autID;
		this.pics=pics;
	}
	public Books() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
