<!-- 
 * @authors Shaunak Sangdod,Nayanika Bhargava,Rahul Chhapgar, Darshan Patel
 * Team 7  ||  Software Engineering 
 * Copyright 2017, all right reserved.
 * Date written: 07/03/2017. (mm/dd/yyyy)
 * Last modified: 08/14/2017. (mm/dd/yyyy)
 * version 7
 * Groupinder Web-application.
-->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>
<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Groupinder</title>

<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="bootstrap/css/style.css" rel="stylesheet">
<script type="text/javascript" src="bootstrap/js/signup.js"></script>
</head>

<body class="background-G">
	
	<!-- Application Logo and title of page -->
	
	<div>
		<h3 class="logo text-center">G</h3>
		<h2 class="text-center">Registration</h2>
	</div>

	<!-- Form to register user starts here -->

	<div class="middle-box text-center">
		<div>
			<form name="myform" class="m-t" role="form" action="RegisterServlet" method="post">
				<div class="form-group">
					<input type="text" class="form-control" name="name" placeholder="Name" required>
				</div>
				<div class="form-group">
					<input type="email" name="email" class="form-control" placeholder="Email" required>
				</div>
				<div class="form-group">
					<input type="password" class="form-control" name="password"	placeholder="Password" required>
				</div>
				<div class="form-group">
					<input type="password" class="form-control" name="retypepassword" id="exampleInputPasswordAgain" placeholder="Retype Password" required>
				</div>
				<div class="input-group">
					<span class="input-group-addon" id="basic-addon1">+1</span>
					<input type="hidden" name="phone_number_country_code" value="+1">
					<input type="text" class="form-control" placeholder="Mobile Number" aria-describedby="basic-addon1" id="mobile" name="mobileno" required>
				</div> <br>
				<button type="submit" class="btn btn-primary block full-width m-b" onclick="validate()">Register</button>

				<p class="text-muted text-center">
					<small>Already having a Groupinder account ?</small>
				</p>
				<a class="btn btn-sm btn-white btn-block" href="index.jsp">Login</a>
			</form>
		</div>
	</div>
	
	<!-- Form to register user ends here -->
	
	<!-- @authors Rahul_Chhapgar, Darshan_Patel Form *version-2* 07/09/2017 (mm/dd/yyyy)	-->
</body>
</html>