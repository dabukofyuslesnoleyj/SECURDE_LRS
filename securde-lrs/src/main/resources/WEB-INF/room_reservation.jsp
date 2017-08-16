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

	<script type="text/javascript" src="js/room_reservation.js"></script>
	<link rel="stylesheet" type="text/css" href="css/room_reservation.css"/>
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
			<li><a href="#">Borrow</a></li>
			<li><a href="#">Reserve</a></li>
			<li><a href="#">Account</a></li>
			<li><a href="#">Logout</a></li>
		</ul>
	</nav>
	<!--  -->
	
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
		<button name="reserve" id="room-reservation-button">Reserve</button>
	</div>
</body>
</html>
