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

	<script type="text/javascript" src="js/room_reservation_manager.js"></script>
	<link rel="stylesheet" type="text/css" href="css/room_reservation_manager.css"/>
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
			<li><a href="#">Manage Reservations</a></li>
			<li><a href="#">Account</a></li>
			<li><a href="#">Logout</a></li>
		</ul>
	</nav>
	<!--  -->
	
	<h3 id="reservation-list-header">Rooms</h3>
	<div class="room-reservation-form">
		<table class="room-reservation-table">
			<tr>
				<th>Rooms</th>
				<th>7:00</th>
				<th>7:30</th>
				<th>8:00</th>
				<th>8:30</th>
				<th>9:00</th>
				<th>9:30</th>
				<th>10:00</th>
				<th>10:30</th>
				<th>11:00</th>
				<th>11:30</th>
				<th>12:00</th>
				<th>12:30</th>
				<th>13:00</th>
				<th>13:30</th>
				<th>14:00</th>
				<th>14:30</th>
				<th>15:00</th>
				<th>15:30</th>
				<th>16:00</th>
				<th>16:30</th>
				<th>17:00</th>
				<th>17:30</th>
				<th>18:00</th>
				<th>18:30</th>
				<th>19:00</th>
				<th>19:30</th>
			</tr>
<!-- 			<tr> -->
<!-- 				<th>E101</th> -->
<!-- 				<td class="time-slot" state="0"></td> -->
<!-- 				<td class="time-slot" state="0"></td> -->
<!-- 				<td class="time-slot" state="0"></td> -->
<!-- 				<td class="time-slot" state="0"></td> -->
<!-- 				<td class="time-slot" state="0"></td> -->
<!-- 				<td class="time-slot" state="0"></td> -->
<!-- 				<td class="time-slot" state="0"></td> -->
<!-- 				<td class="time-slot" state="0"></td> -->
<!-- 				<td class="time-slot" state="0"></td> -->
<!-- 				<td class="time-slot" state="0"></td> -->
<!-- 				<td class="time-slot" state="0"></td> -->
<!-- 				<td class="time-slot" state="0"></td> -->
<!-- 				<td class="time-slot" state="0"></td> -->
<!-- 				<td class="time-slot" state="0"></td> -->
<!-- 				<td class="time-slot" state="0"></td> -->
<!-- 				<td class="time-slot" state="0"></td> -->
<!-- 				<td class="time-slot" state="0"></td> -->
<!-- 				<td class="time-slot" state="0"></td> -->
<!-- 				<td class="time-slot" state="0"></td> -->
<!-- 				<td class="time-slot" state="0"></td> -->
<!-- 				<td class="time-slot" state="0"></td> -->
<!-- 				<td class="time-slot" state="0"></td> -->
<!-- 				<td class="time-slot" state="0"></td> -->
<!-- 				<td class="time-slot" state="0"></td> -->
<!-- 				<td class="time-slot" state="0"></td> -->
<!-- 				<td class="time-slot" state="0"></td> -->
<!-- 			</tr> -->
		</table>
		<div id="room-slot-details">
			<p id="room-slot-roomId" value="0">Room ID#: </p>
			<p id="room-slot-timeslot" startH="0" startM="0" endH="0" endM="0">Timeslot: </p>
			<p id="room-slot-reserveeId" value="0">Reservee ID#: </p>
		</div>
		<form id="room-slot-override-form" method="post">
			Reservee ID#: <input id="room-slot-override-reserveeId" type="text" value="0">
			Availability: <select id="room-slot-override-availability">
							<option value="0">Available</option>
							<option value="1">Unavailable</option>
						  </select>
			<input type="button" id="room-slot-override-button" value="Override">
		</form>
	</div>
</body>
</html>
