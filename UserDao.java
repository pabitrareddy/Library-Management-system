package com.tech.library.Dao;

import java.sql.*;

import com.tech.library.model.Books;
import com.tech.library.model.User;
public class UserDao {
	
	private Connection con;
	
	public UserDao(Connection con) {
		super();
		this.con = con;
	}
	
	//METHOD TO INSERT USER TO DATA
	public boolean saveUser(User user) {
		boolean f=false;
		try {
			//user-->database
			
			String query="insert into user(name,email,password,phone)values(?,?,?,?)";
			PreparedStatement psmt=this.con.prepareStatement(query);
			psmt.setString(1, user.getName());
			psmt.setString(2, user.getEmail());
			psmt.setString(3, user.getPass());
			psmt.setLong(4, user.getPhone());
			psmt.executeUpdate();
			f=true;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return f;
	}
	//get user by usermail and userpassword
	public User getUserByEmailAndPassword(String email,String pass) {
		User user=null;
		try {
			
			String query="select * from user where email=? and password=?";
			PreparedStatement psmt=con.prepareStatement(query);
			psmt.setString(1, email);
			psmt.setString(2, pass);
			
			ResultSet rs=psmt.executeQuery();
			if(rs.next()) {
				user=new User();
	//			data from db			
				String name=rs.getString("name");
	//			set to user object			
				user.setName(name);
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setPass(rs.getString("password"));
				user.setPhone(rs.getLong("phone"));
				user.setDateTime(rs.getTimestamp("reg_date"));
				user.setProfile(rs.getString("profile"));
				user.setUserType(rs.getString("userType"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return user;
		
		
		
	}
	public boolean updateUser(User user) {
		
		boolean f=false;
		try {
			String query="update user set name=?,email=?,password=?,phone=?,profile=? where id=?";
			PreparedStatement psm=con.prepareStatement(query);
			psm.setString(1, user.getName());
			psm.setString(2, user.getEmail());
			psm.setString(3, user.getPass());
			psm.setLong(4, user.getPhone());
			psm.setString(5, user.getProfile());
			psm.setInt(6, user.getId());
			psm.executeUpdate();
			f=true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return f;
	}
	//METHOD TO GET USER BY ID
	public User getUserById(int userId) {
	    User user = null;
	    try {
	        PreparedStatement p = con.prepareStatement("SELECT * FROM user WHERE id = ?");
	        p.setInt(1, userId);
	        ResultSet set = p.executeQuery();
	        if (set.next()) {
	        	int id=set.getInt("id");
	        	String name=set.getString("name");
	        	String email=set.getString("email");
	    
	        	Long phone=set.getLong("phone");
	        	Timestamp date=set.getTimestamp("reg_date");
	        	String image=set.getString("profile");
	            user= new User(id,name,email,null, phone,date,image);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return user;
	}

}
