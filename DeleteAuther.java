package com.tech.library.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tech.library.Dao.BooksDao;
import com.tech.library.helper.ConnectionProvider;
import com.tech.library.model.Message;

/**
 * Servlet implementation class DeleteAuther
 */
@WebServlet("/DeleteAuther")
public class DeleteAuther extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAuther() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			int id=Integer.parseInt(request.getParameter("id"));
			HttpSession session=request.getSession();
			BooksDao dao=new BooksDao(ConnectionProvider.getConnection());
			boolean f=dao.deleteAuther(id);
			
			if(f) {
				Message msge=new Message("Auther details Deleted....","success","alert-success");
				
				session.setAttribute("msg", msge);
				response.sendRedirect("author.jsp");
			}else {
				Message msge=new Message("Something went worng","error","alert-danger");
				
				session.setAttribute("msg", msge);
				response.sendRedirect("author.jsp");
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
