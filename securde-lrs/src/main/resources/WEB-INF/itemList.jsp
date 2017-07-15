<html>

    <head>

        
         <link rel="stylesheet" type="text/css" href="utils/bootstrap/css/bootstrap.min.css"/>
        <script src="utils/jquery-3.2.1.min.js"></script>
        <script src="utils/bootstrap/js/bootstrap.min.js"></script>

        <link rel="stylesheet" type="text/css" href="css/itemList.css"/>

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

        <div class="container">

            <div class="row" id="title_row">
            <h2>Library Items</h2>
        </div>
        <div class="row" id="search_filter_row">

            <div id="search_div" class="col-md-4">
                <input type="text" id="search_text" placeholder="Search"></input>
            </div>

            <div id="type_filter_div" class="col-md-4">
                <label class="checkbox-inline">
                <input type="checkbox" value="books">Books
                </label>
                <label class="checkbox-inline">
                <input type="checkbox" value="magazines">Magazines
                </label>
                <label class="checkbox-inline">
                <input type="checkbox" value="thesis">Thesis
                </label>
            </div>

            <div id="sort_div" class="col-md-4">
                <select>
                    <option>
                    </option>
                </select>
                <button type="button" class="btn btn-primary btn-sm">Ascending</button>
            </div>
        </div>

        <div class="row" id="itemlist_row">
            
            <div class="row item_container">
                
                <div class="item_image col-md-1">
                    <img src="rsc/img/bookCover.jpg" class="img-responsive item_cover"/>
                </div>
                
                <div class="item_info col-md-11">
                    <div class="row item_info_upper_row">
                        <div class="item_info_name_div col-md-4">
                            <p class="item_info_name">Book of Worlds</p>
                        </div>
                        <div class="item_info_author_div col-md-4">
                            <p>by</p><p class="item_info_author">John Doe</p>
                        </div>
                        <div class="item_info_rating_div col-md-4">
                            <p>9.5</p><p>/10</p>
                        </div>
                    </div>
                    <div class="row item_info_lower_row">
                        <div class="item_info_type_div col-md-3">
                            <p class="item_info_type">Book</p>
                        </div>
                        <div class="item_info_tags_div col-md-9">
                            <ul class="list-inline">
                                <li class="list-inline-item"><span class="label label-default">New</span></li>
                                <li class="list-inline-item"><span class="label label-default">Sci-Fi</span></li>
                                <li class="list-inline-item"><span class="label label-default">Thriller</span></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        
        </div>

        </div>

    </body>

</html>