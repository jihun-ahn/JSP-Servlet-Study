<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="grade.dto.UserDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 메뉴</title>
</head>
<body>
	<% UserDTO dto = (UserDTO)session.getAttribute("dto"); %>
	<form action="SelectScore" method="POST">
		<table>
			<tr>
				<td><%=dto.getId() %>(<%=dto.getName() %>)님 환영합니다.</td>
			</tr>
			<tr>
				<td><input type="button" value="개인 성적 조회" onclick="location.href='SelectScore?name=${dto.name}'"></td>
				<td><input type="button" value="클래스 성적 조회" onclick="location.href='SelectScore'"></td>
			</tr>
		</table>
	</form>
</body>
</html>