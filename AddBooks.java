package com.tech.library.controller;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.tech.library.Dao.BooksDao;
import com.tech.library.helper.ConnectionProvider;
import com.tech.library.helper.Helper;
import com.tech.library.model.Books;
import com.tech.library.model.Message;

/**
 * Servlet implementation class AddBooks
 */

@WebServlet("/AddBooks")
@MultipartConfig
public class AddBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBooks() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String bName=request.getParameter("addbook");
		int bISBN= Integer.parseInt(request.getParameter("isbn"));
		Double price = Double.parseDouble(request.getParameter("price"));
		int catName=Integer.parseInt(request.getParameter("catname"));
		String autName=request.getParameter("auther");
		Part part=request.getPart("pics");
		HttpSession session=request.getSession();
		Books book=new Books(bName,bISBN,price, null, catName,autName, part.getSubmittedFileName() );
		BooksDao dbook=new BooksDao(ConnectionProvider.getConnection());
		if(dbook.saveBook(book)) {	
			
			
			String path = request.getRealPath("/") + "bookpics" + File.separator + part.getSubmittedFileName();
			Helper.saveFile(part.getInputStream(), path);
			response.sendRedirect("books.jsp");
			
			Message msge=new Message("Books details Added Successfuly....","success","alert-success");
			
			session.setAttribute("msg", msge);
			
		}else {
			out.println("error");
			Message msge=new Message("Something went worng","error","alert-danger");
			
			session.setAttribute("msg", msge);
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
