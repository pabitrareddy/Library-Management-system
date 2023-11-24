package com.tech.library.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tech.library.Dao.IssueBookDao;
import com.tech.library.helper.ConnectionProvider;
import com.tech.library.model.IssueBook;

/**
 * Servlet implementation class EditissueBook
 */
@WebServlet("/EditissueBook")
public class EditissueBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditissueBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());	
		
		
		 		String status = request.getParameter("status");
		        int fine = Integer.parseInt(request.getParameter("fine"));
		       
		        String approveParam = request.getParameter("approve");
		        int id = Integer.parseInt(request.getParameter("id"));

		        // Check and handle null or unexpected value for "approve"
		        boolean approve = "Approve".equalsIgnoreCase(approveParam);

		        IssueBook issuebook = new IssueBook(); 
		        issuebook.setStatus(status);
		        issuebook.setFine(fine);
		        
		        issuebook.setAproved(approve);
		        issuebook.setIssueId(id);

		        IssueBookDao dao = new IssueBookDao(ConnectionProvider.getConnection());
		        boolean f = dao.updateIssubook(issuebook);

		        HttpSession session = request.getSession();
		        if (f) {
		            response.sendRedirect("issueBook.jsp");
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
