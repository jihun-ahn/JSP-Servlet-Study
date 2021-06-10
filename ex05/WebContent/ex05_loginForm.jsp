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
		if(session.getAttribute("id")!=null){
			response.sendRedirect("ex05_main.jsp");
		}
	%>

	<form action="ex05_testLogin.jsp">
		아이디 : <input type="text" name="userid"><br>
		비밀번호 : <input type="password" name="userpwd"><br>
		<input type="submit" value="로그인">
	</form>
</body>
</html>