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
                url: "/submitPost",
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

    $("p[class='lead']").each(function(){
       $(this).html(replace($(this).text())) ;
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

function replace(inputText){
    var replacePattern1 = /(\b(https?|ftp):\/\/[-A-Z0-9+&@#\/%?=~_|!:,.;]*[-A-Z0-9+&@#\/%=~_|])/gim;
    var replacedText = inputText.replace(replacePattern1, '<a href="$1" target="_blank">$1</a> <br>');

    //URLs starting with www. (without // before it, or it'd re-link the ones done above)
    var replacePattern2 = /(^|[^\/])(www\.[\S]+(\b|$))/gim;
    var replacedText = replacedText.replace(replacePattern2, '$1<a href="http://$2" target="_blank">$2</a> <br>');

    //Change email addresses to mailto:: links
    var replacePattern3 = /(\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,6})/gim;
    var replacedText = replacedText.replace(replacePattern3, '<a href="mailto:$1">$1</a> <br>');

    return replacedText
}