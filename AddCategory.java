package com.tech.library.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tech.library.Dao.BooksDao;
import com.tech.library.helper.ConnectionProvider;
import com.tech.library.model.Category;
import com.tech.library.model.Message;

/**
 * Servlet implementation class AddCategory
 */
@WebServlet("/AddCategory")
public class AddCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String categoryName = request.getParameter("category");
		    String categoryStatus = request.getParameter("status");
		    HttpSession session=request.getSession();
		    // Create a new Category object
		    Category category = new Category(categoryName, categoryStatus, false);

		    // Save the category to the database
		    BooksDao bookd = new BooksDao(ConnectionProvider.getConnection());
		    if (bookd.saveCategory(category)) {
		        // Redirect the user back to the category page
		    	Message msge=new Message("Category details Added Successfuly....","success","alert-success");
				
				session.setAttribute("msg", msge);
		        response.sendRedirect("category.jsp");
		    }else {
		    	Message msge=new Message("Something Went Worng","error","alert-danger");
				
				session.setAttribute("msg", msge);
		        response.sendRedirect("category.jsp");
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
	


