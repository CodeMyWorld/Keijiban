$(document).ready(function(){
    $("#login_button").click(function(){
        var login = {
            username: $("#username_login").val(),
            password: $("#password_login").val()
        };

        $.ajax({
            type: "POST",
            url: "/user/login",
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
});

function goHomePage(){
    location.href="/post/homePage"
}