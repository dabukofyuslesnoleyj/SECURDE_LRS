function item_info(){
    $.post("rest/account/register",
            {
                itemId : $()
            },
            function(success, status, message, data, errorData){
                if(success){
                    var name = data.item_name;
                    var authors = data.item_authors;
                    var publisher = data.item_publisher;
                    var tags = data.item_tags;

                    $("#item_name").val(name);
                    $.each(
                        authors,
                        function (i, val){
                            $("#item_authors").append("<span> "+val.l+", "+val.f+" </span>");
                        }
                    );
                    $("#item_publisher").val(publisher);
                    $.each(
                        tags,
                        function (i, val){
                            $("#item_tags").append("<li class='list-inline-item'><span class='label label-default'> "+val+" </span></li>");
                        }
                    );

                    var review_list = $("review-list");

                    $.each(
                        review_list,
                        function (i, val){
                            review_list.append(
                                'div class="media">'+
                                '    <div class="media-left">'+
                                '        <img alt="prof-pic" src="#" class="media-object">'+
                                '    </div>'+
                                '    <div class="media-body">'+
                                '        <h4 class="media-heading">'+data.review_list.username+'</h4>'+
                                '        <p>'+data.review_list.review+'</p>'+
                                '    </div>'+
                                '    <div class="media-right">'+
                                '        <h4>Rating</h4>'+
                                '        <p>'+data.review_list.rating+'</p>'+
                                '    </div>'+
                                '</div>'
                            );
                        }
                    );
                }
        })
        .done(function(){
            
        })
        .fail(function(){
            
        });
}

function reviewItem(){

    var review_text = $("#review_text");

    if(review_text.val() != ""){
        $.post("rest/account/register",
            {
                itemId : $(),
                review : review_text
            },
            function(success, status, message, data, errorData){
                if(success){
                    
                }
        })
        .done(function(){
            
        })
        .fail(function(){
            
        });
    }

    
}

function rateItem(){
    $.post("rest/account/register",
            {
                itemId : $(),
                rating : $("#review_text")
            },
            function(success, status, message, data, errorData){
                if(success){
                    
                }
        })
        .done(function(){
            
        })
        .fail(function(){
            
        });
}

function borrowItem(){
    $.post("rest/account/register",
            {
                itemId : $()
            },
            function(success, status, message, data, errorData){
                if(success){
                    $("#item_available").val("Available "+data.available);
                    $("#item_reserved").val("Reserved "+data.reserved);
                }
        })
        .done(function(){
            
        })
        .fail(function(){
            
        });
}

$(document).ready(function(){



});