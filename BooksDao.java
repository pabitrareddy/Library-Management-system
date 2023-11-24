package com.tech.library.Dao;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.tech.library.model.Auther;
import com.tech.library.model.Books;
import com.tech.library.model.Category;

public class BooksDao {

	private Connection con;

	public BooksDao(Connection con) {
		this.con = con;
	}
	
	
	//METHOD TO INSERT 	CATEGORY TO DATA
	public boolean saveCategory(Category category) {
		boolean f=false;
		try {
			//category-->database
			
			String query="insert into categories(name,status)values(?,?)";
			PreparedStatement psmt=this.con.prepareStatement(query);
			psmt.setString(1, category.getcName());
			psmt.setString(2, category.getStatus());
			psmt.executeUpdate();
			f=true;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return f;
	}
	
	//METHOD TO Display 	CATEGORY TO DATA
	public ArrayList<Category> getAllCategory(){
	    ArrayList<Category> list = new ArrayList<>(); // Initialize the list
	    
	    try {
	        String q="select * from categories";
	        Statement st=this.con.createStatement();
	        ResultSet set=st.executeQuery(q);
	        while(set.next()) {
	            int cides=set.getInt("cid");
	            String cNames=set.getString("name");
	            Timestamp date=set.getTimestamp("date");
	            String status=set.getString("status");
	            Category cat=new Category(cides,cNames,date,status, false);
	            
	            list.add(cat);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return list;
	}
	//METHOD TO update 	CATEGORY TO DATA
	//MEDHOD TO GET CATEGORY BY ID
	public Category getCategoryById(int catId) {
		Category cat=null;
		try {
			PreparedStatement p = con.prepareStatement("SELECT * FROM categories WHERE cid = ?");
	        p.setInt(1, catId);
	        ResultSet set = p.executeQuery();
	        if(set.next()) {
	        	int cId=set.getInt("cid");
	        	String cNames=set.getString("name");
	            Timestamp date=set.getTimestamp("date");
	            String status=set.getString("status");
	            cat=new Category(cId,cNames,date,status, false);
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cat;
		
	}
	
	
	
	//METHOD TO Delete 	CATEGORY TO DATA
	public boolean deletCategory(int catid) {
		boolean f=false;
		try {
			String sql="delete from categories where cid=?";
			PreparedStatement psm=con.prepareStatement(sql);
			psm.setInt(1, catid);
			int i=psm.executeUpdate();
			if(i==1) {
				f=true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return f;
		
	}
	
	//!-------Books---------!
	//METHOD TO INSERT 	CATEGORY TO DATA
		public boolean saveBook(Books book) {
			boolean f=false;
			try {
				//category-->database
				
				String query="insert into book(bName,bISBN,bPrice,catId,Aid,pic)values(?,?,?,?,?,?)";
				PreparedStatement psmt=this.con.prepareStatement(query);
				psmt.setString(1, book.getbName());
				psmt.setInt(2, book.getbISBN());
				psmt.setDouble(3, book.getbPrice());
				
				psmt.setInt(4, book.getCatID());
				psmt.setString(5, book.getAutID());
				psmt.setString(6, book.getPics());
				
				psmt.executeUpdate();
				f=true;
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return f;
		}
		//METHOD TO Display 	BOOKs  DATA
		public ArrayList<Books> getAllBooks(){
		    ArrayList<Books> lists = new ArrayList<>(); // Initialize the list
		    
		    try {
		        String q="select * from book order by bId desc";
		        Statement st=this.con.createStatement();
		        ResultSet set=st.executeQuery(q);
		        
		        while(set.next()) {
		            int bId=set.getInt("bId");
		            String bNames=set.getString("bName");
		            int bISBN=set.getInt("bISBN");
		            Double dPrice=set.getDouble("bPrice");
		            Timestamp bDate=set.getTimestamp("bDate");
		            int catName=set.getInt("catId");
		            String autName=set.getString("Aid");
		            String bPicsName=set.getString("pic");
		            
		            Books book=new Books(bId,bNames,bISBN,dPrice,bDate,catName,autName,bPicsName);
		            
		            lists.add(book);
		            
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    return lists;
		}
		
		public List<Books> getBookByCatId(int catId){
		List<Books>	list=new ArrayList<>();
		 try {
		        PreparedStatement p=con.prepareStatement("select * from book where catId=?");
		        p.setInt(1, catId);
		        ResultSet set =p.executeQuery();
		        while(set.next()) {
		            int bId=set.getInt("bId");
		            String bNames=set.getString("bName");
		            int bISBN=set.getInt("bISBN");
		            Double dPrice=set.getDouble("bPrice");
		            Timestamp bDate=set.getTimestamp("bDate");
		            int catName=set.getInt("catId");
		            String autName=set.getString("Aid");
		            String bPicsName=set.getString("pic");
		           
		            Books book=new Books(bId,bNames,bISBN,dPrice,bDate,catName,autName,bPicsName);
		            
		            list.add(book);
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		return list;
		}
		
		
		
		//METHOD TO update 	Book TO DATA
		
		public boolean updateBook(Books book) {
			boolean f=false;
			try {
				String query="update book set bName=?,bISBN=?,bPrice=?,catId=?,Aid=?,pic=? where bId=?";
				PreparedStatement psm=con.prepareStatement(query);
				psm.setString(1, book.getbName());
				psm.setInt(2, book.getbISBN());
				psm.setDouble(3, book.getbPrice());
				
				psm.setInt(4, book.getCatID());
				psm.setString(5, book.getAutID());
				psm.setString(6, book.getPics());
				psm.setInt(7, book.getbID());
				psm.executeUpdate();
				f=true;
			} catch (Exception e) {
				// TODO: handle exception
			}
			return f;
			
		}
		
		//MEDHOD TO GET BOOK BY ID
		public Books getBookById(int bookId) {
		    Books book = null;
		    try {
		        PreparedStatement p = con.prepareStatement("SELECT * FROM book WHERE bId = ?");
		        p.setInt(1, bookId);
		        ResultSet set = p.executeQuery();
		        if (set.next()) {
		            int bId = set.getInt("bId");
		            String bName = set.getString("bName");
		            int bISBN = set.getInt("bISBN");
		            Double bPrice = set.getDouble("bPrice");
		            Timestamp bDate = set.getTimestamp("bDate");
		            int catId = set.getInt("catId");
		            String autName = set.getString("Aid");
		            String bPicsName = set.getString("pic");

		            book = new Books(bId, bName, bISBN, bPrice, bDate, catId, autName, bPicsName);
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    return book;
		}

		
		
		
		//METHOD TO Delete 	Book TO DATA
		public boolean deleteBooks(int id) {
			boolean f=false;
			try {
				String sql="delete from book where bId=?";
				PreparedStatement psm=con.prepareStatement(sql);
				psm.setInt(1, id);
				int i=psm.executeUpdate();
				if(i==1) {
					f=true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return f;
			
		}
		
		
		
//		!-------Auther------!
		//METHOD TO INSERT 	AUTHER  DATA
		public boolean saveAuther(Auther auther) {
			boolean f=false;
			try {
				//category-->database
				
				String query="insert into auther(Aname)values(?)";
				PreparedStatement psmt=this.con.prepareStatement(query);
				psmt.setString(1, auther.getaName());
				psmt.executeUpdate();
				f=true;
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return f;
		}	
		//METHOD TO Display 	AUTHER  DATA
				public ArrayList<Auther> getAllAuther(){
				    ArrayList<Auther> listses = new ArrayList<>(); // Initialize the list
				    
				    try {
				        String q="select * from auther";
				        Statement st=this.con.createStatement();
				        ResultSet set=st.executeQuery(q);
				        while(set.next()) {
				            int aId=set.getInt("Aid");
				            String aNames=set.getString("Aname");
				            Timestamp aDate=set.getTimestamp("Atime");
				            Auther auther=new Auther(aId,aNames, aDate);
				            
				            listses.add(auther);
				        }
				    } catch (Exception e) {
				        e.printStackTrace();
				    }

				    return listses;
				}
		
		
	//METHOD TO DELETE AUTHER	
		public boolean deleteAuther(int aid) {
			boolean f=false;
			try {
				String sql="delete from auther where Aid=?";
				PreparedStatement psm=con.prepareStatement(sql);
				psm.setInt(1, aid);
				int i=psm.executeUpdate();
				if(i==1) {
					f=true;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			return f;
			
		}
}
