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
	<div>
		<div class="col-4">
			<img alt="Item" src="#">
		</div>
		<div class="col-4">
			<h3>Book Name</h3>
			<p>Author</p>
			<p>Publisher</p>
			<p>Tag</p><button>+</button>
		</div>
		<div class="col-4">
			<h3>Score</h3>
			<img alt="all over 10" src="#">
			<p>Available #</p>
			<select name="item-select-quantity">
				<option value="1">1</option>
			</select><button>Borrow</button>
		</div>
	</div>
	<!--  -->
	
	<!-- item Reviews -->
	<!-- Note: scrollable using CSS -->
	<div>
		<div class="row-1">
			<div class="col-2"><img alt="prof-pic" src="#"></div>
			<p>Rating</p>
			<p>kjhjkhkhkjljhlkjjhdfdfhgjkh hgkjhlkjh jhlkj h</p>
		</div>
	</div>
	
</body>
</html>