$(document).ready(function(){
        $("#submitbutton").click(function(){
            console.log("ajax");
            var postContent = {
                content: $("#content").val(),
                nickname: $("#nickname").val()
            };

            console.log(postContent)
            $.ajax({
                type: "POST",
                url: "submitPost",
                data: postContent,
                success: function(data, status){
                    console.log(status+" "+data);
                    goHomePage();
                },
                error: function(request, status, error){
                    console.log("error");
                }
            });
        });

    $("#login_button").click(function(){
        var login = {
            username: $("#username_login").val(),
            password: $("#password_login").val()
        };

        $.ajax({
            type: "POST",
            url: "/login",
            data: login,
            success: function(data, status, xhr){
                console.log(data);
                goHomePage();
            },
            error: function(){
                console.log("error");
            }
        })
    });

    $.ajax({
        type:"GET",
        url:"/getsession",
        success: function (data) {
            console.log(data)
            $("#nickname").val(data.nickname);
            $("#username-show").text("Hello "+data.username);
        }
    })
});

function goHomePage(){
    location.href="/homePage/1"
}