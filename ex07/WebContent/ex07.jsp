<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	pageContext.setAttribute("name1", "페이지");
	request.setAttribute("name1", "리퀘스트");
	session.setAttribute("name1", "세션");
	application.setAttribute("name1", "어플리케이션");
%>

page 속성 : ${pageScope.name1}<br>
request 속성 : ${requestScope.name1}<br>
session 속성 : ${sessionScope.name1}<br>
application 속성 : ${applicationScope.name1}<br>
<hr>
name 값 : ${name}<br>
</body>
</html>