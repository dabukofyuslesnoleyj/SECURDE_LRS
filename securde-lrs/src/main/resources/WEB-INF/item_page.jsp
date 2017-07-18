<!--<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%> -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
     <link rel="stylesheet" type="text/css" href="utils/bootstrap/css/bootstrap.min.css"/>
        <script src="utils/jquery-3.2.1.min.js"></script>
        <script src="utils/bootstrap/js/bootstrap.min.js"></script>
		<link rel="stylesheet" type="text/css" href="css/index.css"/>
     <link rel="stylesheet" type="text/css" href="css/item_page.css"/>
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
	<div class="container">
		<div class="row">
			<div class="col-md-2">
				<img src="#">
			</div>
			<div class="col-md-6">
				<h3 id="item_name">Book Name</h3>
				<div id="item_author">Author</div>
				<p id="item_publisher">Publisher</p>
				<div>
					<ul class="item_tags list-inline-item">
					</ul>
				</div><button>+</button>
			</div>
			<div class="col-md-4">
				<h3>Score</h3>
				<img src="#">
				<div class="row">
					<div class="col-md-4"><p id="item_available">Available #</p></div>
					<div class="col-md-4"><p id="item_reserved">Reserved #</p></div>
					<div class="col-md-4"><p id="item_out">Out #</p></div>
				</div>
				
				<select name="item-select-quantity">
					<option value="1">1</option>
				</select>
				<button id="borrow-button" data-toggle="modal" data-target="#borrow-modal">Borrow</button>
			</div>
		</div>
	</div>
	
	<!--  -->
	
	<!-- Modals -->
	<div class="modal fade" id="borrow-modal" role="dialog">
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
					<button id="borrow-modal-confirm" data-dismiss="modal">Confirm</button>
					<button id="borrow-modal-close" data-dismiss="modal">Close</button>
				</div>
			</div>
			
		</div>
	</div>
	
	<div class="modal fade" id="review-modal" role="dialog">
		<div class="modal-dialog">
			
			<!-- Modal Content -->
			<div class="modal-content">
				<div class="modal-header">
					<button class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Review</h4>
				</div>
				<div class="modal-body">
					<textarea name="textarea-review" class="form-control" id="review_text"></textarea>
				</div>
				<div class="modal-footer">
					<button id="borrow-modal-confirm" data-dismiss="modal">Confirm</button>
					<button id="borrow-modal-close" data-dismiss="modal">Close</button>
				</div>
			</div>
			
		</div>
	</div>
	<!--  -->
	
	
	<!-- item Reviews -->
	<!-- Note: scrollable using CSS -->
	
	<div class="container-fluid">
		<button id="review-button" data-toggle="modal" data-target="#review-modal">Write Review</button>
		<div id="review-list">
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
		</div>
	</div>
	
	
</body>
</html>