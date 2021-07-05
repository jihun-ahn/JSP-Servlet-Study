<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="grade.dto.UserDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 메뉴</title>
<link rel="stylesheet" href="css/grade.css">
</head>
<body>
	<jsp:include page="include/header.jsp"/>
	<jsp:include page="include/nav.jsp"/>
	<section>
	<% UserDTO dto = (UserDTO)session.getAttribute("dto"); %>
	<form action="SelectScore" method="POST">
		<table border="1">
			<tr>
				<td><input type="button" value="개인 성적 조회" onclick="location.href='SelectScore?name=${dto.name}'"></td>
				<td>
					<input type="submit" value="클래스 성적 조회">
					<input type="hidden" name="s_class" value="${dto.u_class}">
				</td>
			</tr>
		</table>
	</form>
	</section>
	<jsp:include page="include/footer.jsp"/>
</body>
</html>