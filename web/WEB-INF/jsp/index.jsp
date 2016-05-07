<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 16-5-2
  Time: 下午6:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
  <title>Bootstrap 101 Template</title>

  <!-- Bootstrap -->
  <link href="/css/bootstrap.min.css" rel="stylesheet">
  <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
  <script src="/js/jquery-1.12.2.min.js"></script>
  <!-- Include all compiled plugins (below), or include individual files as needed -->
  <script src="/js/bootstrap.min.js"></script>
  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <script src="/js/index.js"></script>
  <!--[if lt IE 9]>
  <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body>
<div class="container">
  <div class="col-md-5 col-md-offset-3">
      <div class="form-group">
        <label for="username">Email address</label>
        <input class="form-control" id="username" placeholder="Your name" name="username">
      </div>
      <div class="form-group">
        <label for="password">Password</label>
        <input type="password" class="form-control" id="password" placeholder="Password" name="password">
      </div>
      <button id="login_button" type="submit" class="btn btn-primary">Sign In</button>
      <button  class="btn btn-default" data-toggle="modal" data-target="#register">Sign Up</button>
  </div>
</div>




<div class="modal fade" id="register">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">Modal title</h4>
      </div>

      <div class="modal-body">
        <div class="form-group">
          <label for="username_login">Email address</label>
          <input type="text" class="form-control" id="username_login" placeholder="Username" name="username">
        </div>
        <div class="form-group">
          <label for="password_login">Password</label>
          <input type="password" class="form-control" id="password_login" placeholder="Password" name="password">
        </div>
        <div class="form-group">
          <label for="password-confirm">Password</label>
          <input type="password" class="form-control" id="password-confirm" placeholder="Confirm Password" name="confirm_pass">
        </div>
      </div>
      <div class="modal-footer">
        <button id="register-button" class="btn btn-default" data-dismiss="modal">Sign In</button>
      </div>
    </div>
  </div>
</div>

<div class="modal fade" id="info">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">Info</h4>
      </div>

      <div class="modal-body">
        <P id="info_content" class="bg-primary"></P>
      </div>
    </div>
  </div>
</div>
</body>
</html>
