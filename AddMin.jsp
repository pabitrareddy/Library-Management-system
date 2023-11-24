<%@page import="com.tech.library.model.IssueBook"%>
<%@page import="com.tech.library.Dao.IssueBookDao"%>
<%@page import="com.tech.library.model.Books"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tech.library.Dao.BooksDao"%>
<%@page import="com.tech.library.helper.ConnectionProvider"%>
<%@page import="com.tech.library.Dao.UserDao"%>
<%@page import="com.tech.library.model.Message"%>
<%@page import="com.tech.library.model.User"%>
<%

User user=(User)session.getAttribute("currentUser");

if(user==null){
	response.sendRedirect("Login-page.jsp");
	return;
}else{
	if(user.getUserType().equals("normaluser")){
		response.sendRedirect("Login-page.jsp");
		return;
	}
}

BooksDao book=new BooksDao(ConnectionProvider.getConnection()); 
ArrayList<Books> lists=book.getAllBooks();
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>


<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<link rel="stylesheet" href="css/Mystyle.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	<link rel="stylesheet" href="css/Addmin.css">
<link rel="stylesheet" href="css/stylesheet.css" />
    	<!-- Boxicons CSS -->
    <link
      href="https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css"
      rel="stylesheet"
    />
<meta charset="ISO-8859-1">
<title>AddMin</title>
</head>
<body>
<!-- Navbar -->
<%@include file="AdminNav.jsp" %>
<section class="home-section">
<%@include file="AddMinNormalNav.jsp" %>
<br>
<br>
<%IssueBookDao issu= new IssueBookDao(ConnectionProvider.getConnection());
ArrayList<IssueBook> list=issu.getAllissuBook();
User users=(User)session.getAttribute("currentUser");
%>
<div class="container admin">
<div class="row mt-5">
	<div class="col-md-4">
	<a href="books.jsp">
		<div class="card">
		
			<div class="card-body text-center">
				<div class="container">
				<img  style="max-width:100px;" class="img-fluid rounded-rectangale" src="images/book.png" alt="book_icon">
				</div>
			<h5 class="mt-2"><%=lists.size() %></h5>
			<h5 class="text-uppercase text-muted">Book List</h5>
			</div>
			
		</div>
	</a>
	</div>
	
	<div class="col-md-4">
	<a href="category.jsp">
		<div class="card">
			<div class="card-body  text-center">
				<div class="container">
				<img  style="max-width:100px;" class="img-fluid rounded-circle" src="images/categories.png" alt="book_icon">
				</div>
			<p class="mt-2">Click here to add new category</p>
			<h5 class="text-uppercase text-muted">Category</h5>
			</div>
		</div>
	</a>
	</div>
	
	<div class="col-md-4">
	<a href="author.jsp">
		<div class="card">
			<div class="card-body  text-center">
				<div class="container">
				<img  style="max-width:100px;" class="img-fluid rounded-circle" src="images/authority.png" alt="book_icon">
				</div>
			<p class="mt-2">Click here to add new Author</p>
			<h5 class="text-uppercase text-muted">Author</h5>
			</div>
		</div>
	</a>
	</div>
	
</div>
<!-- second row -->
<div class="row mt-3">
	<div class="col-md-6">
	<a href="issueBook.jsp">
		<div class="card">
			<div class="card-body text-center">
				<div class="container">
				<img  style="max-width:100px;" class="img-fluid rounded-rectangale" src="images/reading.png" alt="book_icon">
				</div>
			
			<h5 class="mt-2"><%=list.size() %></h5>
			<h5 class="text-uppercase text-muted">Book Issued</h5>
			</div>
		</div>
	</a>
	</div>
	<%
	UserDao dao=new UserDao(ConnectionProvider.getConnection());
	int total=dao.getTotalUsers();
	%>
	
	<div class="col-md-6">
	<a href="AllUser.jsp">
		<div class="card">
			<div class="card-body  text-center">
				<div class="container">
				<img  style="max-width:100px;" class="img-fluid rounded-circle" src="images/man.png" alt="book_icon">
				</div>
			<h5><%=total %></h5>
			<h5 class="text-uppercase text-muted">Register User</h5>
			</div>
		</div>
	</a>
	</div>
	
	
	
</div>
</div>
</section>


<script>
let sidebar = document.querySelector(".sidebar");
let closeBtn = document.querySelector("#btn");

closeBtn.addEventListener("click", () => {
  sidebar.classList.toggle("open");
  menuBtnChange(); //calling the function(optional)
});

// following are the code to change sidebar button(optional)
function menuBtnChange() {
  if (sidebar.classList.contains("open")) {
    closeBtn.classList.replace("bx-menu", "bx-menu-alt-right"); //replacing the iocns class
  } else {
    closeBtn.classList.replace("bx-menu-alt-right", "bx-menu"); //replacing the iocns class
  }
}

 </script>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>