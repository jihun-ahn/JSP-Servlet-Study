<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="grade.dto.UserDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>선생 메뉴</title>
<link rel="stylesheet" href="css/grade.css">
</head>
<body>
	<jsp:include page="include/header.jsp"/>
	<jsp:include page="include/nav.jsp"/>
	<section>
	<% UserDTO dto = (UserDTO)session.getAttribute("dto"); %>
	<form action="SelectTeacher" method="POST">
		<table border="1">
			<tr>
				<td><input type="submit" value="학생 조회"></td>
				<td><input type="button" value="과목 조회" onclick="location.href='SelectTeacher'"></td>
			</tr>
		</table>
	</form>
	</section>
</body>
</html>