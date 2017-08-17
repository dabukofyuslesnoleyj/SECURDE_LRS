<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	<script src="jquery-3.2.1.min.js"></script>
     
    <link rel="stylesheet" href="utils/bootstrap/css/bootstrap.min.css">
    <script src="utils/bootstrap/js/bootstrap.min.js"></script>
	
	<link rel="stylesheet" type="text/css" href="css/admin.css"/>
</head>
<body>
	<!-- NAV BAR AREA -->
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">GreenDesk</a>
			</div>
		</div>
		<ul class="nav navbar-nav">
			<li><a href="#">Manage Items</a></li>
			<li><a href="#">Rooms</a></li>
			<li><a href="#">Account</a></li>
			<li><a href="#">Logout</a></li>
		</ul>
	</nav>
	<!--  -->
	<div id="admin-account-create-container" class="col-md-5">
		<div class="panel-heading">Create Account</div>
		<div class="panel panel-default" id="admin-account-create">
			<form id="admin-account-create-form">
				<div class="panel-body">ID#: <input id="admin-account-create-academicId" type="text"></div>
				<div class="panel-body">Academic Type:
					<select id="admin-account-create-academicType">
						<option value="faculty">Faculty</option>
						<option value="student">Student</option>
					</select></div>
				<div class="panel-body">Assign as:
					<select id="admin-account-craete-libraryPosition">
						<option value="staff">Staff</option>
						<option value="manager">Manager</option>
					</select></div>
				<div class="panel-body"><button id="admin-account-create-button">Create Account</button></div>
			</form>
		</div>
	</div>
	<div id="admin-account-list-container" class="col-md-5">
		<div class="panel-heading">Account List</div>
		<div class="panel panel-default" id="admin-account-list">
			<div class="media">
				<div class="media-left">
					<img alt="prof-pic" src="#" class="media-object">
				</div>
				<div class="media-body">
					<h4 class="media-heading">IDNUMBER</h4>
					<p>PASSWORD</p>
					<p>Staff</p>
				</div>
				<div class="media-right">
					<button class="admin-unlock-account" value="X">Unlock</button>
					<button class="admin-delete-account" value="X">Delete</button>
				</div>
			</div>
			<div class="media">
				<div class="media-left">
					<img alt="prof-pic" src="#" class="media-object">
				</div>
				<div class="media-body">
					<h4 class="media-heading">IDNUMBER</h4>
					<p>PASSWORD</p>
					<p>Manager</p>
				</div>
				<div class="media-right">
					<button class="admin-unlock-account" value="X">Unlock</button>
					<button class="admin-delete-account" value="X">Delete</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
