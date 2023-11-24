package com.tech.library.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tech.library.Dao.*;
import com.tech.library.helper.ConnectionProvider;
import com.tech.library.model.Message;

/**
 * Servlet implementation class DeleteUser
 */
@WebServlet("/DeleteUser")
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			int id=Integer.parseInt(request.getParameter("id"));
			HttpSession session=request.getSession();
			UserDao dao=new UserDao(ConnectionProvider.getConnection());
			boolean f=dao.deleteUserById(id);
			if(f) {
				Message msge=new Message("User details Deleted....","success","alert-success");
				
				session.setAttribute("msg", msge);
				response.sendRedirect("AllUser.jsp");
			}else {
				Message msge=new Message("Something went worng","error","alert-danger");
				
				session.setAttribute("msg", msge);
				response.sendRedirect("AllUser.jsp");
			}
		} catch (Exception e) {
			// TODO: handle exception
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
