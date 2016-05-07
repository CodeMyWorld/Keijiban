$(document).ready(function(){
    $("#login_button").click(function(){
        var login = {
            username: $("#username").val(),
            password: $("#password").val()
        };

        $.ajax({
            type: "POST",
            url: "login",
            data: login,
            success: function(data, status, xhr){
                console.log(data);
                if(data == "success"){
                    goHomePage();
                }else{
                    $("#info_content").text("sign in fail");
                    $("#info").modal("show");
                }

            },
            error: function(){
                console.log("error");
            }
        })
        
        
    });
    
    $("#register-button").click(function () {
        $.ajax({
            type:"POST",
            url:"register",
            data:{
                username: $("#username_login").val(),
                password: $("#password_login").val(),
                confirmPass:$("#password-confirm").val()
            },
            success:function(data){
                console.log(data);
                if(data == "success"){
                    $("#info_content").text("Sign Up success");
                    $("#info").modal("show");
                    location.href="/index";
                }else if(data == "exist"){
                    $("#info_content").text("User name has already existed");
                    $("#info").modal("show");
                }else{
                    $("#info_content").text("both password are not the same");
                    $("#info").modal("show");
                }
            },
            error: function (data) {

            }
        })
    })
});

function goHomePage(){
    location.href="/homePage/1"
}