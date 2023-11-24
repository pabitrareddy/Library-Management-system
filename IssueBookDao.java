package com.tech.library.Dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.tech.library.model.Books;
import com.tech.library.model.Category;
import com.tech.library.model.IssueBook;

public class IssueBookDao {

	private Connection con;

	public IssueBookDao(Connection con) {
		this.con = con;
	}
	
	//METHOD TO INSERT ISSUE DATA STORE DATABASE
		public boolean saveIssudata(IssueBook issuebook) {
			boolean f=false;
			try {
				//category-->database
				
				String query="insert into issue_book(bookName,userId,bookId,userName)values(?,?,?,?)";
				PreparedStatement psmt=this.con.prepareStatement(query);
				psmt.setString(1, issuebook.getBookName());
				psmt.setInt(2, issuebook.getUserId());
				psmt.setInt(3, issuebook.getBookIBSN());
				psmt.setString(4, issuebook.getUserName());
				
				int i=psmt.executeUpdate();
				if(i==1) {
				f=true;
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return f;
		}

	//METHOD TO GET ALL THE DATA IN DATABASE
		public ArrayList<IssueBook> getAllissuBook() throws SQLException {
			 ArrayList<IssueBook> lists = new ArrayList<>(); 
			String query="select * from issue_book";
			 Statement st=this.con.createStatement();
		      ResultSet set=st.executeQuery(query);
		    
		        while(set.next()) {
		        	int issuId=set.getInt("issueId");
		        	String bookName=set.getString("bookName");
		        	String bookStatus=set.getString("bookStatus");
		        	Timestamp issuDate=set.getTimestamp("issueDate");
		        	int fine=set.getInt("fine");
		        	String userName=set.getString("userName");
		        	boolean approve=set.getBoolean("bookAprove");
		        	
		        	IssueBook issubook=new IssueBook(issuId,bookName,bookStatus,issuDate,fine,0, 0, approve, userName);
		        	lists.add(issubook);
		        }
			
			return lists;
			
		}
		// METHOD TO GET ISSUBOOK BY ID 
		public IssueBook getIssuebookById( int issueId) {
			IssueBook b=null;
			try {
				String query="select * from issue_book  where issueId=?";
				PreparedStatement psm=con.prepareStatement(query);
				psm.setInt(1, issueId);
				ResultSet rs=psm.executeQuery();
				while(rs.next()) {
					b=new IssueBook();
					b.setIssueId(rs.getInt(1));
					b.setBookName(rs.getString(2));
					b.setBookIBSN(rs.getInt(3));
					b.setUserName(rs.getString(4));
					b.setStatus(rs.getString(5));
					b.setFine(rs.getInt(6));
					b.setAproved(rs.getBoolean(7));
					b.setUserId(rs.getInt(8));
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			
			return b;
			
		}
		//METHOD GET UPDATE ISSUE BOOK
		public boolean updateIssubook(IssueBook issuebook) {
		    boolean f = false;
		    try {
		        String query = "update issue_book set bookStatus=?, fine=?, bookApprove=? where issueId=?";
		        PreparedStatement psm = con.prepareStatement(query);
		        psm.setString(1, issuebook.getStatus());
		        psm.setInt(2, issuebook.getFine());
		        psm.setBoolean(3, issuebook.isAproved());  // Assuming the correct getter is isApproved()
		        psm.setInt(4, issuebook.getIssueId());
		        int i = psm.executeUpdate();
		        if (i == 1) {
		            f = true;
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    return f;
		}

	
}
