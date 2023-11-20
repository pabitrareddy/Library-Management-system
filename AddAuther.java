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
import com.tech.library.model.Auther;
import com.tech.library.model.Message;

/**
 * Servlet implementation class AddAuther
 */
@WebServlet("/AddAuther")
public class AddAuther extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAuther() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String AutherName=request.getParameter("auther");
		HttpSession session=request.getSession();
		Auther auther=new Auther(AutherName, null);
		BooksDao aDao=new BooksDao(ConnectionProvider.getConnection());
		
		if(aDao.saveAuther(auther)) {

			Message msge=new Message("Auther details Added Successfuly....","success","alert-success");
			
			session.setAttribute("msg", msge);
			response.sendRedirect("author.jsp");
		}else {
			Message msge=new Message("Something Went Worng","error","alert-danger");
			
			session.setAttribute("msg", msge);
			response.sendRedirect("author.jsp");
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
