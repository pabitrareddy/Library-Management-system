<%@page import="java.util.List"%>
<%@page import="com.tech.library.Dao.UserDao"%>
<%@page import="com.tech.library.model.User"%>
<%@page import="com.tech.library.model.Message"%>
<%@page import="com.tech.library.model.Auther"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tech.library.helper.ConnectionProvider"%>
<%@page import="com.tech.library.Dao.BooksDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%
	UserDao dao=new UserDao(ConnectionProvider.getConnection());
  	ArrayList<User> list=dao.getAllUsers();
	%>
<!DOCTYPE html>
<html>
<head >
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<link rel="stylesheet" href="css/Mystyle.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	 <link rel="stylesheet" href="css/stylesheet.css" />
    	<!-- Boxicons CSS -->
    <link
      href="https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css"
      rel="stylesheet"
    />
<meta charset="ISO-8859-1">
<title>Auther</title>
</head>
<body>
<!-- Navbar -->
<%@include file="AdminNav.jsp" %>
 <section class="home-section">
<%@include file="AddMinNormalNav.jsp" %>
<br>
<br>
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
<div class="container">

<h3>All User</h3>
</div>
<div class="container text-center">
<table class="table table-striped">
  <thead>
    <tr>
       <th scope="col">ID</th>
      <th scope="col">Name</th>
      <th scope="col">Email</th>
        <th scope="col">Phone</th>
        <th scope="col">RegisterDate</th>
    </tr>
  </thead>
  <tbody>
  <%
     
      for (User user : list) {
   %>
  <tr>
	      
	      <td><%=user.getId() %></td>
	      <td><%=user.getName() %></td>
	      <td><%=user.getEmail() %></td>
	      <td><%=user.getPhone() %></td>
	      <td><%=user.getDateTime() %></td>
	     
	    
      <td><a href="DeleteAuther?id=" class="btn btn-sm btn-primary">Update</a>
			<a href="DeleteUser?id=" class="btn btn-sm btn-danger">Delete</a>
    </tr>
  <%} %>
  </tbody>
</table>
</div>

</section>
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
       <form action="AddAuther" action="post">
        	<div class="form-group">
        	<label>Auther :</label>
        	<input type="text" placeholder="Enter AutherName" class="form-control" name="auther"/>
        	</div>
        <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary">Submit</button>
       
      </div>
      </form>
      </div>
      
    </div>
  </div>
</div>


 <script>
  let sidebar = document.querySelector(".sidebar");
  let closeBtn = document.querySelector("#btn");
  let searchBtn = document.querySelector(".bx-search");
  closeBtn.addEventListener("click", ()=>{
    sidebar.classList.toggle("open");
    menuBtnChange();//calling the function(optional)
  });
  searchBtn.addEventListener("click", ()=>{ // Sidebar open when you click on the search iocn
    sidebar.classList.toggle("open");
    menuBtnChange(); //calling the function(optional)
  });
  // following are the code to change sidebar button(optional)
  function menuBtnChange() {
   if(sidebar.classList.contains("open")){
     closeBtn.classList.replace("bx-menu", "bx-menu-alt-right");//replacing the iocns class
   }else {
     closeBtn.classList.replace("bx-menu-alt-right","bx-menu");//replacing the iocns class
   }
  }
 </script>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>