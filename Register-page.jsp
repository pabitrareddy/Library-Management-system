<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<link rel="stylesheet" href="css/Mystyle.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<meta charset="ISO-8859-1">
<title>Registere Page</title>
</head>
<body>
	<!-- Navbar -->
	<%@include file="Normalnavbar.jsp" %>

	<main class=" p-5">
		<div class="container">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-header text-center primary-background text-black">
					<span class="fa fa-3x fa-user-circle "></span>
					<br>
						Register Here
					</div>
					<div class="card-body">
						
						<form id="reg-form" action="Register" method="post">
						 <div class="mb-3">
						    <label for="user_name" class="form-label">User Name</label>
						    <input type="text" name="user_name" class="form-control" id="user_name" aria-describedby="emailHelp">
						  </div>
						   <div class="mb-3">
					    <label for="exampleInputEmail1" class="form-label">Email address</label>
					    <input type="email" name="user_email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
				
					  </div>
						  
						  <div class="mb-3">
						    <label for="exampleInputPassword1" class="form-label">Password</label>
						    <input type="password" name="pass" class="form-control" id="exampleInputPassword1">
						  </div>
						   <div class="mb-3">
						    <label for="user_phone" class="form-label">User Phone</label>
						    <input type="text" name="phone" class="form-control" id="user_phone" aria-describedby="emailHelp">
						   
						  </div>
					  
					 
					  <div class="mb-3 form-check">
					    <input type="checkbox"  name="check" class="form-check-input" id="exampleCheck1">
					    <label class="form-check-label" for="exampleCheck1">Check me out</label>
					  </div>
					  <button type="submit" class="btn btn-primary">SignUp</button>
					</form>
					
					</div>
					<div class="card-footer">
					
					
					</div>
				</div>
			
			
			
			
			</div>
		</div>
	</main>

<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
<script>
$(document).ready(function(){
	console.log("loaded.....")
	$('#reg-form').on('submit',function(event){
		event.preventDefault();
		let form=new FormData(this);
		$.ajax({
			url:"Register",
			type:'POST',
			data: form,
			success:function(data, textStatus, jqxHR){
				console.log(data)	
			if(data.trim()==='done'){	
				swal("Registered successfully..we are going to redirecting to login page")
				.then((value) => {
				  window.location="Login-page.jsp"
				});
			}else{
				swal(data);
			}
			},
			error: function (jqXHR, textStatus, errorThrown){
				swal("something went worng...try again")
				
			},
			processData:false,
			contentType:false
		});
	});
	
});
</script>
</body>
</html>