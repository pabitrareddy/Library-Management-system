<%@page import="com.tech.library.model.Message"%>
<%@page import="com.tech.library.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page errorPage="Error-page.jsp" %>   
 <% 
 User user=(User)session.getAttribute("currentUser");
 if(user==null){
	 response.sendRedirect("Login-page.jsp");
 }
 
  %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<link rel="stylesheet" href="css/Mystyle.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	<link rel="stylesheet" href="css/Addmin.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary primary-background text-white">
  <div class="container-fluid">
    <a class="navbar-brand" href="index.jsp"><span class="	fa fa-institution"></span> YOURLIBRARY</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#"><span class="	fa fa-home"></span> Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#"><span class="	fa fa-star-half-empty"></span> About</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            <span class="fa fa-check-square"></span> Categories
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li><a class="dropdown-item" href="#">Newbook</a></li>
            <li><a class="dropdown-item" href="#">Oldbook</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="#">Book</a></li>
          </ul>
        </li>
        <li class="nav-item">
          <a class="nav-link active " aria-current="page" href="#"><span class="	fa fa-tablet"></span> Contact</a>
        </li>
       
      </ul>
    </div>
    <ul class="navbar-nav mr-right">
	   <li class="nav-item">
	      <a class="nav-link active" href="#!" data-toggle="modal" data-target="#profile-model"><span class="fa  fa-user-circle	"></span> <%=user.getName() %></a>
	    </li>
	   <li class="nav-item">
	      <a class="nav-link active "  href="Logout"><span class="fa fa-user-plus"></span> Logout</a>
	    </li>
  </ul>
  </div>
</nav>
<!-- end of navbar -->
<%
Message ms=(Message)session.getAttribute("msg");
if(ms!=null){
	%>
	<div class="alert <%=ms.getCssClass() %>" role="alert">
  		<%=ms.getContent() %>
	</div>
	
	<% 
	session.removeAttribute("msg");
}
	
%>

<div class="container admin">
<div class="row mt-5">
	<div class="col-md-4">
	
		<div class="card">
			<div class="card-body text-center">
				<div class="container">
				<img  style="max-width:100px;" class="img-fluid rounded-rectangale" src="images/book.png" alt="book_icon">
				</div>
			
			<h5 class="mt-2">243</h5>
			<h5 class="text-uppercase text-muted">Book List</h5>
			</div>
		</div>
	
	</div>
	
	<div class="col-md-4">
	<a href="Cat_book.jsp">
		<div class="card">
			<div class="card-body  text-center">
				<div class="container">
				<img  style="max-width:100px;" class="img-fluid rounded-circle" src="images/categories.png" alt="book_icon">
				</div>
			<p class="mt-2">Click here to category wise Book</p>
			<h5 class="text-uppercase text-muted">Category</h5>
			</div>
		</div>
	</a>
	</div>
	
	<div class="col-md-4">
		<div class="card">
			<div class="card-body  text-center">
				<div class="container">
				<img  style="max-width:100px;" class="img-fluid rounded-circle" src="images/authority.png" alt="book_icon">
				</div>
			<p class="mt-2">Click here to add new Author</p>
			<h5 class="text-uppercase text-muted">Author</h5>
			</div>
		</div>
	
	</div>
	
</div>
<!-- second row -->
<div class="row mt-3">
	<div class="col-md-6">
		<div class="card">
			<div class="card-body text-center">
				<div class="container">
				<img  style="max-width:100px;" class="img-fluid rounded-rectangale" src="images/reading.png" alt="book_icon">
				</div>
			
			<h5 class="mt-2">243</h5>
			<h5 class="text-uppercase text-muted">Book Issued</h5>
			</div>
		</div>
	
	</div>
	
	<div class="col-md-6">
		<div class="card">
			<div class="card-body  text-center">
				<div class="container">
				<img  style="max-width:100px;" class="img-fluid rounded-circle" src="images/man.png" alt="book_icon">
				</div>
			<h5>24</h5>
			<h5 class="text-uppercase text-muted">Register User</h5>
			</div>
		</div>
	
	</div>
	
	
	
</div>
</div>


<!-- Profile model -->


<!-- Modal -->
<div class="modal fade" id="profile-model" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header primary-background text-black">
        <h5 class="modal-title" id="exampleModalLabel">Profile</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <div class="container text-center">
        	<img src="pics/<%= user.getProfile() %>" class="img-fluid" style="border-radius:50%; max-width: 130px;"/>
        	
        	<h5 class="modal-title mt-3" id="exampleModalLabel"><%=user.getName() %></h5>
       <!-- Details -->
       <div id="profile-details">
       <table class="table">
	  
	  <tbody>
	    <tr>
	      <th scope="row">ID :</th>
	      <td><%=user.getId() %></td>
	      
	    </tr>
	    <tr>
	      <th scope="row">Email :</th>
	      <td><%=user.getEmail() %></td>
	      
	    </tr>
	    <tr>
	      <th scope="row">Phone :</th>
	      <td><%=user.getPhone() %></td>
	     
	    </tr>
	    <tr>
	      <th scope="row">Registered on :</th>
	      <td><%=user.getDateTime() %></td>
	     
	    </tr>
	  </tbody>
</table>
</div>
		<!-- profile edit -->
		<div id="profile-edit" style="display:none">
			<h3 class="mt-2">Please Edit Carefully</h3>
			<form action="EditServlet" method="post" enctype="multipart/form-data">
				<table class="table">
					<tr>
						<td>ID :</td>
						<td><%=user.getId() %></td>
						
					</tr>
					<tr>
						<td>Email :</td>
						<td><input type="email"  class="form-control" name="user_email" value="<%= user.getEmail() %>"></td>
						
					</tr>
					<tr>
						<td>Name :</td>
						<td><input type="text"  class="form-control" name="user_name" value="<%= user.getName() %>"></td>
						
					</tr>
					<tr>
						<td>Password :</td>
						<td><input type="password"  class="form-control" name="user_pass" value="<%= user.getPass() %>"></td>
						
					</tr>
					<tr>
						<td>Phone_No :</td>
						<td><input type="text"  class="form-control" name="user_phone" value="<%= user.getPhone() %>"></td>
						
					</tr>
					<tr>
						<td>Profile pic :</td>
						<td><input type="file"  class="form-control" name="image" value="<%= user.getProfile() %>"></td>
						
					</tr>
					
				</table>
			
				<div class="container">
				<button type="submit" class="btn btn-outline-primary">Save</button>
				</div>
			
			
			
			
			</form>
		</div>
       
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button id="edit-profile-buttion" type="button" class="btn btn-primary">Edit</button>
      </div>
    </div>
  </div>
</div>
<!-- End profile model -->

<%---javascript --%>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script>
$(document).ready(function(){
	
	let editStatus=false;
	
	
	$("#edit-profile-buttion").click(function(){
	
		if(editStatus == false){
			$("#profile-details").hide()
			$("#profile-edit").show()
			editStatus=true;
			$(this).text("Back")
		}else {
			$("#profile-details").show()
			$("#profile-edit").hide()
			editStatus=false;
			$(this).text("Edit")
		}
	
		
	});
});
</script>

</body>
</html>