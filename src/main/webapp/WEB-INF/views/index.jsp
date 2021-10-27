<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>Insert title here</title>
		<script src="/webjars/jquery/3.4.1/jquery.min.js"></script>
		<script type="text/javascript">
			var isClicked = false;
			function myClick(){
				console.log('click()');
				if(!isClicked){
					isClicked=true;
					var Pdata = new Object();
					Pdata.name = $('form input[name=name]').val(); 
					Pdata.age = $('form input[name=age]').val(); 
					Pdata.gender = $('form input[name=gender]').val();
					
					$.ajax({
						type:"post",
						url:"/analysis",
						data: Pdata,
						datatype: "json",
						success:function(resultdata){
							console.log('success');
							console.log(resultdata);
							$("#result").append(resultdata.name+" 님 환영합니다."+"<br>");
							$("#result").append("나이는 "+resultdata.age+"세 이며,"+"<br>");
							$("#result").append(resultdata.gender+" 입니다."+"<br>");
						},
						error:function(xhr, status, error){
							console.log('error');
							console.log(xhr + ", "+status+", " + error);
						}
					});
				}
			}
		</script>
	</head>


	<body>
		<h1>test home page</h1>
		<div id="information">
			<form action="home" method="post">
				이름 : <input type="text" name="name" /><br>
				나이 : <input type="text" name="age" /><br>
				성별 : 
				<input type="radio" name="gender" value="M" checked/> 남성
				<input type="radio" name="gender" value="W"/> 여성
				<br><br>
			<button type="submit" >분석</button>
			</form>
		</div>
<!-- 		<button type="button" onclick="myClick()">분석</button> -->
		
		<p id="result"></p>
	</body>
</html>