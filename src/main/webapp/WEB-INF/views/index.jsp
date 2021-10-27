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
							$("#result").append(resultdata.name+" �� ȯ���մϴ�."+"<br>");
							$("#result").append("���̴� "+resultdata.age+"�� �̸�,"+"<br>");
							$("#result").append(resultdata.gender+" �Դϴ�."+"<br>");
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
				�̸� : <input type="text" name="name" /><br>
				���� : <input type="text" name="age" /><br>
				���� : 
				<input type="radio" name="gender" value="M" checked/> ����
				<input type="radio" name="gender" value="W"/> ����
				<br><br>
			<button type="submit" >�м�</button>
			</form>
		</div>
<!-- 		<button type="button" onclick="myClick()">�м�</button> -->
		
		<p id="result"></p>
	</body>
</html>