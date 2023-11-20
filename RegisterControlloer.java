package com.tech.library.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.tech.library.Dao.UserDao;
import com.tech.library.helper.ConnectionProvider;
import com.tech.library.model.User;

/**
 * Servlet implementation class RegisterControlloer
 */
@MultipartConfig
@WebServlet("/Register")
public class RegisterControlloer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterControlloer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		//fetch all form data
		String check=request.getParameter("check");
		if(check==null) {
			out.println("box not checked");
		}else {
			String name=request.getParameter("user_name");
			String email=request.getParameter("user_email");
			String pass=request.getParameter("pass");
			String phone1=request.getParameter("phone");
			
			Long phone=Long.parseLong(phone1);
			//create user object and set all the data object
			User user=new User(name,email,pass,phone);
			
			//create a user dao object
			UserDao dao=new UserDao(ConnectionProvider.getConnection());
			if(dao.saveUser(user)) {
//			save
				out.println("done");
			}else {
				out.println("error");
			}
		}
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
