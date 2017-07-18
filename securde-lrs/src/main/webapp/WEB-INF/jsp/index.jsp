<html>

    <head>
    
        <link rel="stylesheet" type="text/css" href="utils/bootstrap/css/bootstrap.min.css"/>
        <script src="utils/jquery-3.2.1.min.js"></script>
        <script src="utils/bootstrap/js/bootstrap.min.js"></script>

        <link rel="stylesheet" type="text/css" href="css/index.css"/>
        <link rel="stylesheet" type="text/css" href="css/login.css"/>
        <script src="js/loginModal.js"></script>
        <script src="js/register_login.js"></script>

    </head>

    <body>

    <!-- BEGIN # BOOTSNIP INFO -->
    <div class="container">
        <div class="row">
            <h1 class="text-center"><img src="rsc/img/Green Desk New.png"/></h1>
            <p class="text-center"><a href="#" id="modal_button" class="btn btn-primary btn-lg" role="button" data-toggle="modal" data-target="#login-modal">Open Login Modal</a></p>
        </div>
    </div>
    <h1 class="text-center"><img id="skylineImg" src="rsc/img/skyline.png"/></h1>
    <!-- END # BOOTSNIP INFO -->



    <!-- BEGIN # MODAL LOGIN -->
    <div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header" align="center">
                        <img class="img-circle" id="img_logo" src="rsc/img/GreenDeskLogin.png"/>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                        </button>
                    </div>
                    
                    <!-- Begin # DIV Form -->
                    <div id="div-forms">
                    
                        <!-- Begin # Login Form -->
                        <form id="login-form">
                            <div class="modal-body">
                                <div id="div-login-msg">
                                    <div id="icon-login-msg" class="glyphicon glyphicon-chevron-right"></div>
                                    <span id="text-login-msg">Type your username and password.</span>
                                </div>
                                <input id="login_username" class="form-control" type="text" placeholder="Username (type ERROR for error effect)" required>
                                <input id="login_password" class="form-control" type="password" placeholder="Password" required>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox"> Remember me
                                    </label>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <div>
                                    <button type="submit" class="btn btn-primary btn-lg btn-block">Login</button>
                                </div>
                                <div>
                                    <button id="login_register_btn" type="button" class="btn btn-link">Register</button>
                                </div>
                            </div>
                        </form>
                        <!-- End # Login Form -->
                        
                        <!-- Begin | Register Form -->
                        <form id="register-form" style="display:none;">
                            <div class="modal-body">
                                <div id="div-register-msg">
                                    <div id="icon-register-msg" class="glyphicon glyphicon-chevron-right"></div>
                                    <span id="text-register-msg">Register an account.</span>
                                </div>
                                <input id="register_fname" class="form-control" type="text" placeholder="First Name" required/>
                                <input id="register_mname" class="form-control" type="text" placeholder="Middle Name" required/>
                                <input id="register_lname" class="form-control" type="text" placeholder="Last Name" required/>
                                <input id="register_uname" class="form-control" type="text" placeholder="Username" required/>
                                <input id="register_idno" class="form-control" type="text" placeholder="ID Number" required/>
                                <input id="register_bday" class="form-control" type="date"  required/>
                                <input id="register_password" class="form-control" type="password" placeholder="Password" required/>
                                <input id="register_question" class="form-control" type="text" placeholder="Secret Question" required/>
                                <input id="register_answer" class="form-control" type="text" placeholder="Answer" required/>
                            </div>
                            <div class="modal-footer">
                                <div>
                                    <button type="submit" class="btn btn-primary btn-lg btn-block" onclick="register()">Register</button>
                                </div>
                                <div>
                                    <button id="register_login_btn" type="button" class="btn btn-link">Log In</button>
                                </div>
                            </div>
                        </form>
                        <!-- End | Register Form -->
                        
                    </div>
                    <!-- End # DIV Form -->
                    
                </div>
            </div>
    </div>
    <!-- END # MODAL LOGIN -->


    </body>              

</html>