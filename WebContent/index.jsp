<!-- 
 * @authors Shaunak Sangdod,Nayanika Bhargava,Rahul Chhapgar, Darshan Patel
 * Team 7  ||  Software Engineering 
 * Copyright 2017, all right reserved.
 * Date written: 07/01/2017. (mm/dd/yyyy)
 * Last modified: 08/14/2017. (mm/dd/yyyy)
 * version 7
 * Groupinder Web-application.
 * References:
 	1. http://getbootstrap.com/
 	2. https://www.w3schools.com/
 	3. https://v4-alpha.getbootstrap.com/components/ 
 *
-->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Groupinder</title>

<link rel="stylesheet" href="bootstrap/css/style.css">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" />

<script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="bootstrap/js/register.js"></script>

</head>

<body class="background-G">
	
	<!-- Application logo and welcome message -->
	<div>
		<h3 class="logo text-center">G</h3>
		<h2 class="text-center">Welcome to Groupinder</h2>
	</div>
	
	<!-- User login form starts here -->
	
	<div class="middle-box text-center">
		<div>
			<form name="myform" role="form" action="LoginServlet" method="post">
				<div class="form-group">
					<input type="email" name="email" class="form-control" placeholder="Email address" required>
				</div>
				<div class="form-group">
					<input type="password" class="form-control" name="passcode" placeholder="Password" required>
				</div>
				<button type="submit" class="btn btn-primary block full-width m-b">Login</button>

				<p class="text-muted text-center">
					<small>Do not have an account?</small>
				</p>
				<a class="btn btn-sm btn-white btn-block" href="signup.jsp">Create an account</a>
			</form>
		</div>
	</div>

	<!-- User login form ends here -->
	
	<!-- @authors Rahul_Chhapgar, Darshan_Patel Form *version-2* 07/04/2017 (mm/dd/yyyy)	-->
</body>
</html>