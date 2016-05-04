$(document).ready(function(){
    $("button[name='follow']").each(function(){
        $(this).click(function(){
            $.ajax({
                url: "/follow",
                type: "POST",
                data:{
                    userId:$(this).data("userid")
                },
                success:function(){
                    alert("Follow Success")
                }

            })
        })
    })
});