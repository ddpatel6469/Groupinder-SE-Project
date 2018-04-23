<!-- 
 * @authors Shaunak Sangdod,Nayanika Bhargava,Rahul Chhapgar, Darshan Patel
 * Team 7  ||  Software Engineering 
 * Copyright 2017, all right reserved.
 * Date written: 07/30/2017. (mm/dd/yyyy)
 * Last modified: 07/14/2017. (mm/dd/yyyy)
 * version 7
 * Groupinder Web-application.
 * References:
 	1. https://getbootstrap.com/docs/4.0/content/
 	2. https://v4-alpha.getbootstrap.com/components/navbar/#nav
 	3. http://webapplayers.com/inspinia_admin-v2.7.1/calendar.html
-->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.bean.*"%>
<%@ page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>
<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Groupinder</title>

<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="bootstrap/css/jqueryui.css" rel="stylesheet">
<link href="bootstrap/css/style.css" rel="stylesheet">
<link href="bootstrap/css/style_try.css" rel="stylesheet">
<link href="bootstrap/css/custom.css" rel="stylesheet">
<link href="bootstrap/css/fullcalendar.css" rel="stylesheet">
<link href="bootstrap/css/fullcalendar.print.css" rel="stylesheet" media="print">

<script src="bootstrap/js/jquery-3.1.1.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="bootstrap/js/groupinderUI.js"></script>
<script src="bootstrap/js/register.js"></script>
<script src="bootstrap/js/moment.min.js"></script>
<script src="bootstrap/js/icheck.min.js"></script>
<script src="bootstrap/js/fullcalendar.min.js"></script>

<style type="text/css">
	* {
		.border-radius (0) !important;
	}

	#field {
		margin-bottom: 3px;
	}
</style>

<script type="text/javascript">

	function logOut() {
		window.location("LogoutServlet");
	}
	
	$(document).ready(function () {
        $(".ibox").resizable({
            helper: "ui-resizable-helper",
            grid: 20
        });
    });
	   
	$(document).ready(function(){
        WinMove();
    })
    
  	$(document).ready(function(){
    var next = 1;
    $(".add-more").click(function(e){
        e.preventDefault();
        var addto = "#field" + next;
        var addRemove = "#field" + (next);
        next = next + 1;
        var newIn = '<input class="input" id="field' + next + '" name="noteContent' + "" + '" type="text" placeholder="Content"> &nbsp;';
        var newInput = $(newIn);
        var removeBtn = '<button id="remove' + (next - 1) + '" class=" btn-danger remove-me"> - </button></div><div id="field">';
        var removeButton = $(removeBtn);
        $(addto).after(newInput);
        $(addRemove).after(removeButton);
        $("#noteContent" + next).attr('data-source',$(addto).attr('data-source'));
        $("#count").val(next);  		        
            $('.remove-me').click(function(e){
                e.preventDefault();
                var fieldNum = this.id.charAt(this.id.length-1);
                var fieldID = "#noteContent" + fieldNum;
                $(this).remove();
                $(fieldID).remove();
            });
	    });
	});
    
    $(document).ready(function() {
            $('.i-checks').iCheck({
                checkboxClass: 'icheckbox_square-green',
                radioClass: 'iradio_square-green'
            });

        /* initialize the external events  -----------------------------------------------------------------*/

        $('#external-events div.external-event').each(function() {

            // store data so the calendar knows to render an event upon drop
            $(this).data('event', {
                title: $.trim($(this).text()), // use the element's text as the event title
                stick: true // maintain when user navigates (see docs on the renderEvent method)
            });

            // make the event draggable using jQuery UI
            $(this).draggable({
                zIndex: 1111999,
                revert: true,      // will cause the event to go back to its
                revertDuration: 0  //  original position after the drag
            });
        });

        /* initialize the calendar  -----------------------------------------------------------------*/
         <%ArrayList<Reminder> reminders = (ArrayList<Reminder>) session.getAttribute("reminders");%>
		
        var date = new Date();         
		var formattedEventData = [];
		<c:forEach items="${reminders}" var="current_reminder">
	 		 var d = ${current_reminder.d};
	         var m = ${current_reminder.m};
	         var y = ${current_reminder.y};
	  		console.log("hi");
			formattedEventData.push({
				title: '${current_reminder.note_title}',
	        	start: new Date(y,m-1,d,'${current_reminder.hours}','${current_reminder.minutes}'),
	        	allDay: false,
	    	});			    
	    </c:forEach>
	        
        $('#calendar').fullCalendar({
            header: {
                left: 'prev,next today',
                center: 'title',
                right: 'month,agendaWeek,agendaDay'
            },
            editable: true,
            droppable: true, // this allows things to be dropped onto the calendar
            
            drop: function() {
                // is the "remove after drop" checkbox checked?
                if ($('#drop-remove').is(':checked')) {
                    // if so, remove the element from the "Draggable Events" list
                    $(this).remove();
                }
            },           
            events: formattedEventData            
        });
    });
	
</script>

<style type="text/css">

	/* input fields */
	input[type=text], datetime-local {
		width: 40%;
		padding: 3px 10px;
		margin: 3px 3px;
		border: 1px solid #ccc;
		box-sizing: border-box;
	}
	
	/* buttons */
	button {
		background-color: #4CAF50;
		color: white;
		border: none;
		cursor: pointer;
	}
	
	button:hover {
		opacity: 0.8;
	}
	
	.notebtn {
		padding: 10px 18px;
	}
	
	.cancelbtn {
		padding: 10px 18px;
		background-color: #f44336;
	}
	
	.container {
		padding: 16px;
	}
	
	/* The Modal (background) */
	.modal {
		/* 	top: 15%;	right: 15%;		bottom: 30%;	left: 10%;   */
		display: none;
		position: fixed;
		z-index: 1;
		overflow: auto;
		padding-top: 60px;
		background-color: rgb(0, 0, 0);
		background-color: rgba(0, 0, 0, 0.4);
	}
	
	.modal-content {
		background-color: #fefefe;
		margin: 10% 10% 10% 10%;
		border: 1px solid #888;
	}
	
	/* The Modal1 (background) */
	.modal1 {
		display: none;
		z-index: 1;
		overflow: auto;
		padding-top: 60px;
		background-color: rgb(0, 0, 0);
		background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
	}
	
	.modal-content1 {
		background-color: #fefefe;
		margin: -10% 10% 10% 10%;
		border: 1px solid #888;
	}
	
	/* Responsive */
	@media screen and (max-width: 300px) {
		span.psw {
			display: block;
			float: none;
		}
		.cancelbtn {
			width: 50%;
		}
	}
</style>

<script>
	// Get the modal
	var modal = document.getElementById('CreateNote');
	
	window.onclick = function(event) {
	    if (event.target == modal) {
	        modal.style.display = "none"; }
	}
</script>

<script>
	// Get the modal
	var modal = document.getElementById('popup');

	window.onclick = function(event) {
	    if (event.target == modal) {
	        modal.style.display = "none";   }
	}
</script>

<script>
	// Get the modal
	var modal = document.getElementById('userEdit');
	
	window.onclick = function(event) {
	    if (event.target == modal) {
	        modal.style.display = "none";   }
	}
</script>

</head>

<body class=" pace-done">
	<div class="pace  pace-inactive">

		<div class="pace-progress" data-progress-text="100%"
			data-progress="99" style="transform: translate3d(100%, 0px, 0px);">
			<div class="pace-progress-inner"></div>
		</div>
			<%
				User name = new User();
				name = (User) session.getAttribute("currentUser");
				String username = name.user_name;
				String email = name.email;
			%>
		<div class="pace-activity"></div>
	</div>

	<div id="wrapper">

		<nav class="navbar-default navbar-static-side" role="navigation">
			<div class="sidebar-collapse">
				<ul class="nav metismenu" id="side-menu">
					<li class="nav-header">
						<div class="logo-element">
							<a href="user.jsp">G</a>
						</div>
					<li><a href="#"><i class="fa fa-user"></i>
						<span class="nav-label"> <strong class="font-bold">
							<%
							 	if (name == null)
							 		out.print("");
							 	else
							 		out.print("Welcome, " + username);
							 %>
							</strong>
						</span> <span class="caret"></span></a>
						<ul class="nav nav-second-level">
							<li><a onclick="document.getElementById('userEdit').style.display='block'">Profile</a></li>
						</ul>
					</li>
					<li><a href="#"><i class="fa fa-pencil-square-o"></i>
						<span class="nav-label">Notes</span> <span class="caret"></span></a>
						<ul class="nav nav-second-level">
							<li><a onclick="document.getElementById('CreateNotes').style.display='block'">Create</a></li>
							<li><a href="user.jsp">View</a></li>
						</ul>
					</li>
					<li><a href="#"><i class="fa fa-bell-o"></i>
						<span class="nav-label">Reminders</span> <span class="caret"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="/Groupinder/ViewRemindersServlet">Manage</a></li>
						</ul>
					</li>
					<li><a href="#"><i class="fa fa-bookmark-o"></i>
						<span class="nav-label">Labels</span> <span class="caret"></span></a>
						<ul class="nav nav-second-level">
							<%
								String pagetype = (String) request.getParameter("page");
								if (pagetype == null) {
								}
							%>

							<c:set var="pagetype" value="<%=pagetype%>" />
							<c:if test="${pagetype==null}">
								<c:import url="/FetchNotesServlet"> </c:import>
							</c:if>

							<c:forEach items="${notes}" var="note">
								<li><a href="/Groupinder/FetchNotesServlet?key=${note.label}">${note.label}</a>
								</li>
							</c:forEach>
						</ul>
					</li>
					<li><a href="FetchEventsReminderServlet">
						<i class="fa fa-calendar"></i> <span class="nav-label">Calendar</span></a>
					</li>
				</ul>
			</div>
		</nav>

		<div id="page-wrapper" class="gray-bg" style="min-height: 803px;">
			<div class="row border-bottom">
				<nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
					<div class="navbar-header">
						<a class="navbar-minimalize minimalize-styl-2 btn btn-primary" href="#"><i class="fa fa-bars"></i> </a>
						<form role="search" class="navbar-form-custom" action="FetchNotesServlet">
							<div class="form-group">
								<input type="text" placeholder="Search" class="form-control" name="search_key" id="top-search">
							</div>
						</form>
					</div>
					<ul class="nav navbar-top-links navbar-right">
						<li><span class="m-r-sm text-muted welcome-message">
							<%
							 	if (email == null)
							 		out.print("");
							 	else
							 		out.print(email);
							 %>
							</span>
						</li>
						<li><a href="<%=request.getContextPath()%>/LogoutServlet">
								<i class="fa fa-sign-out"> </i> Log out
						</a></li>
					</ul>
				</nav>
			</div>

			<div class="wrapper wrapper-content">
				<div class="row animated fadeInDown">
					<div class="col-lg-9">
						<div class="ibox float-e-margins">

							<div class="ibox-content">
								<div id="calendar"></div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<% User user = (User) session.getAttribute("currentUser"); %>
			<div id="userEdit" class="modal">
				<div>
					<form name="myform" class="m-t modal-content" role="form" action="UpdateUserServlet" method="post">
						<div class="form-group">
							<input type="text" class="form-control" name="name" placeholder="Name" value="<%=user.user_name%>" required>
						</div>
						<div class="form-group">
							<input type="email" name="email" class="form-control" placeholder="Email" value="<%=user.email%>" required>
						</div>
						<div class="form-group">
							<input type="password" class="form-control" name="password" placeholder="Password" required>
						</div>
						<div class="form-group">
							<input type="password" class="form-control" name="retypepassword" id="exampleInputPasswordAgain" placeholder="Retype Password" required>
						</div>
						<div class="input-group">
							<span class="input-group-addon" id="basic-addon1">+1</span> 
							<input type="text" class="form-control" placeholder="Mobile Number" aria-describedby="basic-addon1" id="mobile" name="phone_number_main" placeholder="<%=user.phone_number_main%>" value="<%=user.phone_number_main%>" required>
						</div> <br>
						<button onclick="document.getElementById('userEdit').style.display='none'" type="submit" class="btn notebtn" onclick="validate()">Save</button>
						<button onclick="document.getElementById('userEdit').style.display='none'" type="submit" class="btn cancelbtn">Close</button>
					</form>
				</div>
			</div>

			<div id="CreateReminder" class="modal">
				<form class="modal-content" action="" method="post">
					<div class="container">
						<input type="text" class="input" placeholder="Title" name="title">
						<br> <input type="text" class="input" placeholder="" name="">
						<input type="datetime-local" name="daytime"> <br>
						<button type="submit" class="notebtn">Note it.</button>
						<button type="button" onclick="document.getElementById('CreateReminder').style.display='none';document.getElementById('note2').style.display='block'" class="cancelbtn">Cancel</button>
					</div>
				</form>
			</div>

			<!-- create note demo starts -->

			<div id="CreateNotes" class="modal">
				<form class="modal-content" action="CreateNoteServlet" method="post">
					<div class="container">

						<input type="text" class="input" placeholder="Title" name="noteTitle"> <br>
						<input type="text" class="input" placeholder="Content" name="noteContent"> <br>

						<div class="control-group" id="fields">
							<div class="controls" id="field">
								<input type="text" class="input" id="field1" placeholder="Content" name="noteContent">
								<input type="datetime-local" name="daytime">
								<button id="b1" class="add-more" type="button">+</button>
							</div>
							<input type="text" class="input" placeholder="Label" name="noteLabel"> <br>
							<button type="submit" class="notebtn">Note it</button>
							<button type="button" onclick="document.getElementById('CreateNotes').style.display='none'" class="cancelbtn">Cancel</button>
						</div>
						
					</div>
				</form>
			</div>
			
			<!--  create note demo ends -->
		</div>

	</div>
</body>
</html>