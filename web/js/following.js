$(document).ready(function(){
    $("#head").load("/html/head.html");

    $("button[name='unfollow']").each(function(){
        $(this).click(function(){
            $.ajax({
                typ: "GET",
                url: "/unfollow",
                data:{
                    followId:$(this).data("userid")
                },
                success:function(){
                    alert("unFollow Success");
                },
                error:function(data){

                }
            });
        })
    })
})