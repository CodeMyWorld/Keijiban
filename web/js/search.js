$(document).ready(function(){
    $("#head").load("/html/head.html");

    $("button[name='follow']").each(function(){
        $(this).click(function(){
            $.ajax({
                typ: "GET",
                url: "/follow",
                data:{
                    userId:$(this).data("userid")
                },
                success:function(){
                    alert("unfollow Success");
                },
                error:function(data){

                }
            });
        })
    })
});