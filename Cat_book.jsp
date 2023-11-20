<%@page import="com.tech.library.model.Category"%>
<%@page import="com.tech.library.model.Books"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tech.library.helper.ConnectionProvider"%>
<%@page import="com.tech.library.Dao.BooksDao"%>
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

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@include file="AddMinNormalNav.jsp" %>


	<div class="container-fluid ">
		<div class="row mt-4 ">
		<div class="list-group">
		  <a href="#" onclick="getBooks(0,this)" class=" c-link list-group-item list-group-item-action active" aria-current="true">
		    All Book
		  </a>
		  <%BooksDao book=new BooksDao(ConnectionProvider.getConnection()); 
		  	ArrayList<Category> lists=book.getAllCategory(); 
		  	for(Category cat:lists){
		  	%>
		  <a href="#" onclick="getBooks(<%=cat.getcId() %>,this)" class="c-link list-group-item list-group-item-action"><%=cat.getcName() %></a>
		 <% }%>
		</div>
		<div class="col-md-8" >
			<div class="container text-center" id="loader">
			<i class="fa fa-refresh fa-3x fa-spin"></i>
			<h3 class="mt-2">Loding...</h3>
			</div>
			<div class="container-fluid" id="book-container">
			
			</div>
		</div>
		
		</div>
	</div>








<%---javascript --%>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>


<script >
	function getBooks(catId,temp){
		$("#loader").show();
		$("#book-container").hide();
		$(".c-link").removeClass("active")
		
		
		
		$.ajax({
			url:"load_books.jsp",
			data:{cid:catId},
			success:function(data,textStatus,jqXHR){
				console.log(data);
				$("#loader").hide();
				$("#book-container").show();
				$("#book-container").html(data)
				$(temp).addClass("active")
				
			}
			 
		})
	}
$(document).ready(function (e){
	
	let allBookref=$(".c-link")[0]
	getBooks(0,allBookref)
})

</script>

</body>
</html>