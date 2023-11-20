package com.tech.library.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionActivationListener;

import com.tech.library.Dao.UserDao;
import com.tech.library.helper.ConnectionProvider;
import com.tech.library.model.Message;
import com.tech.library.model.User;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/Login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
//		Login
//		fatch username and password from request
		String userEmail=request.getParameter("email");
		String userPassword=request.getParameter("pass");
		
		UserDao dao=new UserDao(ConnectionProvider.getConnection());
		
		User u=dao.getUserByEmailAndPassword(userEmail, userPassword);
		if(u==null) {
//			login..........
//			error///
			Message msg=new Message("Invalid Details ! try with another","error","alert-danger");
			HttpSession session=request.getSession();
			session.setAttribute("msg", msg);
			
			
			response.sendRedirect("Login-page.jsp");
		}else {
//			Login Success
			HttpSession session=request.getSession();
			session.setAttribute("currentUser", u);
			if(u.getUserType().equals("admin")) {
				response.sendRedirect("AddMin.jsp");
			}else {
			
			response.sendRedirect("profile.jsp");
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
