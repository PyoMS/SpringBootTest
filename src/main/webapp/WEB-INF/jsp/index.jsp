<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>Insert title here</title>
		<script src="/webjars/jquery/3.4.1/jquery.min.jar"></script>
		<script type="text/javascript">
		
			function myClick(){
				console.log('click()');
				var Pdata = new Object();
				Pdata.name = $('form input[name=name]').val(); 
				Pdata.age = $('form input[name=age]').val(); 
				Pdata.gender = $('form input[name=gender]').val();
				
				$.ajax({
					type:"post",
					url:"/analysis",
					data: Pdata,
					datatype: "json",
					success:function(){
						console.log('success');
					},
					error:function(xhr, status, error){
						console.log('error');
						console.log(xhr + ", "+status+", " + error);
					}
					
				});
			}
		
		
		</script>
	</head>


	<body>
		<h1>test home page</h1>
		
		<form>
			이름 : <input type="text" name="name" />
			나이 : <input type="text" name="age" />
		</form>
		<form>
			성별 : 
			<input type="radio" name="gender" value="M"/> 남성
			<input type="radio" name="gender" value="W"/> 여성
		</form>
		
		<button type="button" onclick="myClick()">분석</button>
	</body>
</html>