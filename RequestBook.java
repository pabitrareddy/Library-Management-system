package com.tech.library.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tech.library.Dao.BooksDao;
import com.tech.library.Dao.IssueBookDao;
import com.tech.library.Dao.UserDao;
import com.tech.library.helper.ConnectionProvider;
import com.tech.library.model.Books;
import com.tech.library.model.IssueBook;
import com.tech.library.model.Message;
import com.tech.library.model.User;

/**
 * Servlet implementation class RequestBook
 */
@WebServlet("/RequestBook")
public class RequestBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	PrintWriter out = response.getWriter();
        try {
            String bidParameter = request.getParameter("bid");
            String uidParameter = request.getParameter("uid");

            // Check if bid and uid parameters are not null or empty
            if (bidParameter != null && !bidParameter.isEmpty() && uidParameter != null && !uidParameter.isEmpty()) {
                int bid = Integer.parseInt(bidParameter);
                int uid = Integer.parseInt(uidParameter);
                UserDao dao1= new UserDao(ConnectionProvider.getConnection());
                BooksDao dao = new BooksDao(ConnectionProvider.getConnection());
                Books b = dao.getBookById(bid);
                User u=dao1.getUserById(uid);
                IssueBook issu = new IssueBook();
                issu.setBookName(b.getbName());
                issu.setBookIBSN(bid);
                issu.setUserId(uid);
                issu.setUserName(u.getName());
                IssueBookDao dao2 = new IssueBookDao(ConnectionProvider.getConnection());
                boolean f=dao2.saveIssudata(issu);
                HttpSession session=request.getSession();
                if(f) {
                	Message msge=new Message("Request Added Successfuly....","success","alert-success");
        			
        			session.setAttribute("msg", msge);
                	response.sendRedirect("Cat_book.jsp");
                }else {
                	Message msge=new Message("Something went worng","error","alert-danger");
        			
        			session.setAttribute("msg", msge);
                	response.sendRedirect("Cat_book.jsp");
                }
            } 
        } catch (Exception e) {
            e.printStackTrace();
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
