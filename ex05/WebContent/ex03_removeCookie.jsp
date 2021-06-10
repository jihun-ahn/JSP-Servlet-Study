<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>쿠키를 삭제합니다.</h3>
	<%
		Cookie c = new Cookie("id", "asdgojsdf");
		c.setMaxAge(0);
		
		response.addCookie(c);
	%>
	
	<a href="./ex02_getCookie.jsp">쿠키 삭제확인</a>
</body>
</html>