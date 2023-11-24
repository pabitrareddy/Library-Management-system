<!DOCTYPE html>
<%@page import="com.tech.library.model.IssueBook"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tech.library.helper.ConnectionProvider"%>
<%@page import="com.tech.library.Dao.IssueBookDao"%>
<html lang="en">
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
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Issu Book</title>

    
</head>
<body>

<%IssueBookDao issu= new IssueBookDao(ConnectionProvider.getConnection());
ArrayList<IssueBook> lists=issu.getAllissuBook();
%>
<%@include file="AddMinNormalNav.jsp" %>

<br>
<br>
<div class="container">

<h3>Issue Book</h3>
</div>
<div class="container">
<table class="table table-striped-red">
  <thead>
    <tr class="red-row" >
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
      
		
		<%} %>
    </tr>
    
  </tbody>
</table>
</div>



<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>


<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>


</body>
</html>