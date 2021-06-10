<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>세션에 값 설정하기</h3>
	<%
		session.setAttribute("id", "hong");
		session.setAttribute("pwd", "green123");
		session.setAttribute("name", "홍길동");
		
	%>
	<a href="./ex04_getSession.jsp">세션 저장 값 확인</a>
</body>
</html>