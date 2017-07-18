function initList(){

    $.get("demo_test.asp", 
    function(success, status, message, data, errorData){
        if(success){

            var authors;
            var tags;

            $.each(
                data.tags,
                function (i, val){
                    tags.append("<li class='list-inline-item'><span class='label label-default'> "+val+" </span></li>");
                }
            );

             $.each(
                        data.authors,
                        function (i, val){
                            authors.append("<span> "+val.l+", "+val.f+" </span>");
                        }
                    );

            $("#itemList_row").append(
                '<div class="item_image col-md-1">'+
                '    <img src="rsc/img/bookCover.jpg" class="img-responsive item_cover"/>'+
                '</div>'+
                '<div class="item_info col-md-11">'+
                '    <div class="row item_info_upper_row">'+
                '        <div class="item_info_name_div col-md-4">'+
                '    <p class="item_info_name">'+data.name+'</p>'+
                '        </div>'+
                '        <div class="item_info_author_div col-md-4">'+
                '            <p>by</p><p class="item_info_author">'+authors+'</p>'+
                '        </div>'+
                '        <div class="item_info_rating_div col-md-4">'+
                '            <p>'+data.rating+'</p><p>/10</p>'+
                '        </div>'+
                '    </div>'+
                '    <div class="row item_info_lower_row">'+
                '            <div class="item_info_type_div col-md-3">'+
                '                <p class="item_info_type">'+data.type+'</p>'+
                '            </div>'+
                '            <div class="item_info_tags_div col-md-9">'+
                '                <ul class="list-inline">'+tags+
                '                </ul>'+
                '            </div>'+
                '        </div>'+
                '    </div>'+
                '</div>'
            )
        }
    });

}
/*
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
*/
$(document).ready(function(){



});