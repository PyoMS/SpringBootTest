<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>Insert title here</title>
		<script src="/webjars/jquery/3.4.1/jquery.min.js"></script>
<!-- 		<script src="../js/scripts.js"></script> -->
		<link href="/webjars/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
		<link href="/css/test.css" rel="stylesheet"/>
		
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
		
		<!-- start form submit test -->
<!-- 		<div id="information"> -->
<!-- 			<form action="home" method="post"> -->
<!-- 				이름 : <input type="text" name="name"/><br> -->
<!-- 				나이 : <input type="text" name="age"/><br> -->
<!-- 				성별 :  -->
<!-- 				<input type="radio" name="gender" value="남성" checked/> 남성 -->
<!-- 				<input type="radio" name="gender" value="여성"/> 여성 -->
<!-- 				<br><br> -->
<!-- 			<button type="submit" id="analysisBtn" >분석</button> -->
<!-- 			</form> -->
			<!-- 		<button type="button" onclick="myClick()">분석</button> -->
<!-- 		</div> -->
		<!-- end form submit test -->
		
		<!-- start form:form test - add VO-->
		<section class="projects-section" id="about">
			<div id="information">
				<form:form action="enrollment" method="post" modelAttribute="userInfo"> <!-- @modelAttribute 사용 - VO클래스  -->
					이름 : <input type="text" maxlength="7" name="name"/><br>
					나이 : <input type="number" min="1" max="150" step="1" name="age"/><br> <!-- step은 숫자와의 간격. 소수점나이 x -->
					성별 : 
					<input type="radio" name="gender" value="남성" checked/> 남성
					<input type="radio" name="gender" value="여성"/> 여성
					<br><br>
				<button type="submit" id="analysisBtn" >분석</button>
				<!-- 		<button type="button" onclick="myClick()">분석</button> -->
				</form:form>
			</div>
		</section>
		<!-- end form:form test -->
		<p id="result"></p>
		<section>
			<div>
				<form action="bootstrapTest" method="post">
					<button type="submit">사이트</button>
				</form>
			</div>
		</section>
	</body>
</html>