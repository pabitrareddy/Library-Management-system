package com.tech.library.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.tech.library.Dao.BooksDao;
import com.tech.library.Dao.UserDao;
import com.tech.library.helper.ConnectionProvider;
import com.tech.library.helper.Helper;
import com.tech.library.model.Books;
import com.tech.library.model.Message;

/**
 * Servlet implementation class EditBook
 */
@WebServlet("/EditBook")
@MultipartConfig
public class EditBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String bookName = request.getParameter("book_name");
            String isbnParam = request.getParameter("isbn_no");
            int bISBN = (isbnParam != null && !isbnParam.trim().isEmpty()) ? Integer.parseInt(isbnParam) : 0;
            
            String priceParam = request.getParameter("price_");
            Double price = (priceParam != null && !priceParam.trim().isEmpty()) ? Double.parseDouble(priceParam) : 0.0;

            int catName = Integer.parseInt(request.getParameter("catid"));
            String autName = request.getParameter("autherid");
            Part part = request.getPart("pic");

            String imageName = part.getSubmittedFileName();
            Integer bookId = Integer.parseInt(request.getParameter("book_id"));

            // Retrieve the current book details from the session
            HttpSession session = request.getSession();
            Books book = (Books) session.getAttribute("currentbook");

            // Check if the current book is not null before proceeding
            if (book != null) {
                String oldfile = book.getPics();
                book.setbName(bookName);
                book.setbISBN(bISBN);
                book.setbPrice(price);
                book.setCatID(catName);
                book.setAutID(autName);
                book.setPics(imageName);
                book.setbID(bookId);

                BooksDao bookDao = new BooksDao(ConnectionProvider.getConnection());
                boolean ans = bookDao.updateBook(book);
                if (ans) {
                    String path = request.getRealPath("/") + "bookpics" + File.separator + book.getPics();
                    // Update database
                    String patholdFile = request.getRealPath("/") + "bookpics" + File.separator + oldfile;
                    Helper.deleteFile(patholdFile);
                    if (Helper.saveFile(part.getInputStream(), path)) {
                        Message msg = new Message("Books details updated Successfully....", "success", "alert-success");

                        session.setAttribute("msg", msg);

                    } else {
                        Message msg = new Message("Something went wrong", "error", "alert-danger");

                        session.setAttribute("msg", msg);
                    }
                } else {
                    Message msg = new Message("Something went wrong", "error", "alert-danger");

                    session.setAttribute("msg", msg);
                }
            }
            response.sendRedirect("books.jsp");
        } catch (NumberFormatException | NullPointerException e) {
            e.printStackTrace(); // Log the exception or handle it according to your application's needs
            // Handle the case where a number format exception or null pointer exception occurred
            // You might want to set appropriate error messages and redirect the user to an error page
        }
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
