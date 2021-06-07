<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Addtion02</title>
<!--
<style>css 영역</style>
<script>js영역</script>
-->
</head>
<body>
	<%
	//자바영역
	int num1 = 6;
	int num2 = 7;
	int add = num1+num2;
	%>
	
	<p> <%=num1 %>+<%=num2 %>=<%=add %> </p>
</body>
</html>