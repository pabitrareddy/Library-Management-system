package com.tech.library.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.mysql.cj.Session;
import com.tech.library.Dao.UserDao;
import com.tech.library.helper.ConnectionProvider;
import com.tech.library.helper.Helper;
import com.tech.library.model.Message;
import com.tech.library.model.User;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
@MultipartConfig
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
//		fetch all data
		String userEmail=request.getParameter("user_email");
		String userName=request.getParameter("user_name");
		String userPass=request.getParameter("user_pass");
		String userPhone=request.getParameter("user_phone");
		Long userPhone1=Long.parseLong(userPhone);  
		Part part=request.getPart("image");
		String imageName=part.getSubmittedFileName();
		
//		get the user from the Session........
		
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("currentUser");
		user.setEmail(userEmail);
		user.setName(userName);
		user.setPass(userPass);
		user.setPhone(userPhone1);
		String oldfile=user.getProfile();
		user.setProfile(imageName);
		
		// update database.....
		
		UserDao userDao=new UserDao(ConnectionProvider.getConnection());
		boolean ans=userDao.updateUser(user);
		if(ans) {
			String path=request.getRealPath("/")+"pics"+File.separator+user.getProfile();
//			update database
			String patholdFile=request.getRealPath("/")+"pics"+File.separator+oldfile;
				Helper.deleteFile(patholdFile);
				if(Helper.saveFile(part.getInputStream(), path)) {
					Message msg=new Message("Profile details updated....","success","alert-success");
					
					session.setAttribute("msg", msg);
					
				}else {
					Message msg=new Message("Something went worng","error","alert-danger");
					
					session.setAttribute("msg", msg);
				}
			}else {
				Message msg=new Message("Something went worng","error","alert-danger");
				
				session.setAttribute("msg", msg);
				
				
			}
		response.sendRedirect("profile.jsp");
			
			
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
