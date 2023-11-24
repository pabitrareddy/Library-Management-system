package com.tech.library.model;

import java.sql.Timestamp;

public class IssueBook {

	private int issueId;
	private String bookName;
	private String status;
	private Timestamp date;
	private int fine;
	private int userId;
	private int bookIBSN;
	private boolean aproved=true;
	private String userName;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getIssueId() {
		return issueId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public int getFine() {
		return fine;
	}
	public void setFine(int fine) {
		this.fine = fine;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getBookIBSN() {
		return bookIBSN;
	}
	public void setBookIBSN(int bookIBSN) {
		this.bookIBSN = bookIBSN;
	}
	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}
	public boolean isAproved() {
		return aproved;
	}
	public void setAproved(boolean aproved) {
		this.aproved = aproved;
	}
	public IssueBook(int issueId, String bookName, String status, Timestamp date, int fine, int userId, int bookIBSN,boolean aproved,String userName) {
		super();
		this.issueId = issueId;
		this.bookName = bookName;
		this.status = status;
		this.date = date;
		this.fine = fine;
		this.userId = userId;
		this.bookIBSN = bookIBSN;
		this.aproved=aproved;
		this.userName=userName;
	}
	public IssueBook(String bookName, String status, Timestamp date, int fine,boolean aproved,String userName) {
		super();
		this.bookName = bookName;
		this.status = status;
		this.date = date;
		this.fine = fine;
		this.aproved=aproved;
		this.userName=userName;
	}
	public IssueBook() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
