<html>
    <head>
        <link rel="stylesheet" type="text/css" href="utils/bootstrap/css/bootstrap.min.css"/>
        <script src="utils/jquery-3.2.1.min.js"></script>
        <script src="utils/bootstrap/js/bootstrap.min.js"></script>

        <link rel="stylesheet" type="text/css" href="css/staff_item.css"/>
        <script src="js/staff_item.js"></script>
    </head>

    <body>


         <!-- Modal -->
        <div id="myModal" class="modal fade" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Edit Details</h4>
            </div>
            <div class="modal-body">
               <form>
                    <div class="input-group">
                        <span class="input-group-addon">Name</span>
                        <input id="edit_name" type="text" class="form-control" name="edit_name" placeholder="Edit Item Name">
                    </div>
                    
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Save</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
            </div>

        </div>
        </div>


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

        <div class="container">
        
            <div class="row">

                <div class="col-md-2">
                    <img src="#"/>
                </div>

                <div class="col-md-9">
                    <div class="panel panel-success">
                        <div class="panel-heading" id="item_name">Title</div>
                        <div class="panel-body">
                            <div class="row">
                                <ul class="list-inline" id="item-authors"></ul>
                            </div>
                            <div class="row">
                                <ul class="list-inline" id="item-tags"></ul>
                            </div>
                            <div class="row">
                                <p id="item_desc">Insert Desc Here</p>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-md-1">
                    <div class="row">
                        <p id="item_status">Status: Available</p>
                    </div>
                    <div class="row">
                        <button type="button" class="btn btn-success btn-xs" id="edit_btn" data-toggle="modal" data-target="#myModal">Edit</button>
                    </div>
                </div>

            </div>

        </div>
    </body>
</html>