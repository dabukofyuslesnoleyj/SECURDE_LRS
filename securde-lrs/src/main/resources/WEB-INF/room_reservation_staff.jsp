<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	<script src="jquery-3.2.1.min.js"></script>
     
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

	<script type="text/javascript" src="js/room_reservation_staff.js"></script>
	<link rel="stylesheet" type="text/css" href="css/room_reservation_staff.css"/>
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
	
	<h3 id="reservation-list-header">Rooms</h3>
	<div id="reservation-list-container">
		<div class="media">
			<div class="media-body">
				<h4 class="media-heading">Room #</h4>
				<p>No Reservations</p>
			</div>
			<div class="media-right">
				<button>Disable Room</button>
			</div>
		</div>
		<div class="media">
			<div class="media-body">
				<h4 class="media-heading">Room #</h4>
				<p>XX:00 - XX:00 Lastname, Firstname M.</p>
				<p>XX:00 - XX:00 Lastname, Firstname M.</p>
				<p>XX:00 - XX:00 Lastname, Firstname M.</p>
				<p>XX:00 - XX:00 Lastname, Firstname M.</p>
				<p>XX:00 - XX:00 Lastname, Firstname M.</p>
				<p>XX:00 - XX:00 Lastname, Firstname M.</p>
			</div>
			<div class="media-right">
				<button>Disable Room</button>
			</div>
		</div>
		<div class="media">
			<div class="media-body">
				<h4 class="media-heading">Room #</h4>
				<p>XX:00 - XX:00 Lastname, Firstname M.</p>
				<p>XX:00 - XX:00 Lastname, Firstname M.</p>
			</div>
			<div class="media-right">
				<button>Disable Room</button>
			</div>
		</div>
		<div class="media">
			<div class="media-body">
				<h4 class="media-heading">Room #</h4>
				<p>XX:00 - XX:00 Lastname, Firstname M.</p>
			</div>
			<div class="media-right">
				<button>Disable Room</button>
			</div>
		</div>
	</div>
</body>
</html>