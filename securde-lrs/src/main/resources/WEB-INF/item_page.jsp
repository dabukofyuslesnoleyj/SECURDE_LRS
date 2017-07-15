<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/index.css"/>
     <script src="jquery-3.2.1.min.js"></script>
     
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
     <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

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
	
	<!-- Item Details -->
	<div class="row">
		<div class="col-md-2">
			<img src="#">
		</div>
		<div class="col-md-6">
			<h3>Book Name</h3>
			<p>Author</p>
			<p>Publisher</p>
			<p>Tag</p><button>+</button>
		</div>
		<div class="col-md-4">
			<h3>Score</h3>
			<img src="#">
			<p>Available #</p>
			<select name="item-select-quantity">
				<option value="1">1</option>
			</select>
			<button class="btn btn-info btn-lg" data-toggle="modal" data-target=".myModal">Borrow</button>
		</div>
	</div>
	<!--  -->
	
	<!-- Borrow Modal -->
	<div id="borrow-modal" class="modal fade" role="dialog">
		<div class="modal-dialog">
			
			<!-- Modal Content -->
			<div class="modal-content">
				<div class="modal-header">
					<button class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Borrow Item</h4>
				</div>
				<div class="modal-body">
					<p>Would you like to borrow [Book Name]?</p>
				</div>
				<div class="modal-footer">
					<button id="borrow-modal-confirm" class="btn btn-default" data-dismiss="modal">Confirm</button>
					<button id="borrow-modal-confirm" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
			
		</div>
	</div>
	<!--  -->
	
	
	<!-- item Reviews -->
	<!-- Note: scrollable using CSS -->
	<div class="media">
		<div class="media-left">
			<img alt="prof-pic" src="#" class="media-object">
		</div>
		<div class="media-body">
			<h4 class="media-heading">Username</h4>
			<p>kjhjkhkhkjljhlkjjhdfdfhgjkh hgkjhlkjh jhlkj h</p>
		</div>
		<div class="media-right">
			<h4>Rating</h4>
			<p>99</p>
		</div>
	</div>
	
</body>
</html>