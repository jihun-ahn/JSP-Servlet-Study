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
		if(session.getAttribute("id")==null){
			response.sendRedirect("ex05_loginForm.jsp");
		}

		String id = request.getParameter("userid"); 
		
	%>
	<h3><%=id %>님 환영합니다.</h3>
	<!-- <a href="./ex05_logout.jsp">로그아웃</a> -->
	<form action="ex05_logout.jsp">
		<input type="submit" value="로그아웃">
	</form>
</body>
</html>