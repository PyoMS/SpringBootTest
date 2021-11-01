<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
	<head>
	    <meta charset="utf-8">
	    <!--  This file has been downloaded from bootdey.com @bootdey on twitter -->
	    <!--  All snippets are MIT license http://bootdey.com/license -->
	    <title>Login form with icon - Bootdey.com</title>
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    
		<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
	    <link href="https://netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" rel="stylesheet">
		<script src="https://netdna.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
		
		<!-- start 기존 maven에서 받은 js -->
<!-- 		<script src="/webjars/jquery/3.4.1/jquery.min.js"></script> -->
<!-- 		<link href="/webjars/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet"> -->
<!-- 		<script src="/webjars/bootstrap/4.4.1/js/bootstrap.min.js"></script> -->
		<!-- end 기존 maven에서 받은 js -->
		
		<link href="/css/login.css" rel="stylesheet"/>
	</head>
	<body style="">
		<div class="container bootstrap snippets bootdey">
			<div class="header">
				<ul class="nav nav-pills pull-right">
					<li><a href="#">&nbsp;</a></li>
				</ul>
				<h3 class="text-muted prj-name"><a href="/login">Login</a></h3>
			</div>
			<div style="height:auto;min-height:300px;" class="jumbotron">
		<!-- 	    <div class="col-md-4"> -->
		<!-- 	       <img class="img-responsive center-block img-user" src="assets/img/login_img2.jpg">  -->
		<!-- 	    </div> -->
				<!-- TODO 백그라운드에 img 전체 차지할 수 있게 디자인. -->
				<div class="col-md-0 form-content">
					<form accept-charset="utf-8" method="post" id="UserLoginForm" class="form-signin" action="">    	
						<h1 class="form-signin-heading text-muted">Board</h1>
						<input type="text" id="username" autofocus="autofocus" placeholder="Username" class="form-control" name="username">
						<input type="password" id="password" placeholder="Password" class="form-control" name="password">			
						<button type="button" class="btn btn-lg btn-info btn-block">
							<i class="fa fa-share"></i>
							Login
						</button>
					</form> 
				</div>
				<a class="col-md-2" href="/index">sign up</a>   
			</div>
		</div>
		<div class="col-md-12">     
			<div class="container bootstrap snippets bootdey">     
				<footer class="footer">
					<p>ⓒ Company OriginP 2021</p>
				</footer>
			</div>
		</div>
	</body>
</html>