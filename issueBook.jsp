<%@page import="java.util.ArrayList"%>
<%@page import="com.tech.library.helper.ConnectionProvider"%>
<%@page import="com.tech.library.Dao.IssueBookDao"%>
<%@page import="com.tech.library.model.IssueBook"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
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
<title>Insert title here</title>
</head>
<body>
<!-- Navbar -->
<%@include file="AdminNav.jsp" %>

<section class="home-section">
<%@include file="AddMinNormalNav.jsp" %>
<br>
<br>
<%IssueBookDao issu= new IssueBookDao(ConnectionProvider.getConnection());
ArrayList<IssueBook> lists=issu.getAllissuBook();
%>
<div class="container">

<h3>Issue Book</h3>
</div>
<div class="container">
<table class="table table-striped">
  <thead>
    <tr>
       <th scope="col">ID</th>
      <th scope="col">Book Name</th>
      <th scope="col">User Name</th>
      <th scope="col">Date</th>
      <th scope="col">Status</th>
      <th scope="col">Aproved</th>
        <th scope="col">Fine</th>
       <th scope="col">Action</th>
     
    </tr>
  </thead>
  <tbody>
  <%for(IssueBook issubook : lists) {%>
    <tr>
     
      <td><%=issubook.getIssueId() %></td>
      <td><%=issubook.getBookName() %></td>
      <td><%=issubook.getUserName() %></td>
      <td><%=issubook.getDate() %></td>
      <td><%=issubook.getStatus() %></td>
      <td><%=issubook.isAproved() %></td>
      <td><%=issubook.getFine() %></td>
      <td><a href="edit_Issuebook.jsp?id=<%=issubook.getIssueId() %>" class="btn btn-sm btn-primary">
	  		Update
			</a>
			<a href="#" class="btn btn-sm btn-danger">
	  		Delete
			</a>
		</td>
		<%} %>
    </tr>
    
  </tbody>
</table>
</div>



</section>

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