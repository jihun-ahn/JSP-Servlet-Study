<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>과목 등록</title>
</head>
<link rel="stylesheet" href="css/grade.css">
<body>
	<jsp:include page="include/header.jsp"/>
	<jsp:include page="include/nav.jsp"/>
	<section>
	<form action="InsertSubject" method="POST">
		<table border="1">
			<tr>
				<td><label for="id">과목 id</label></td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td><label for="name">과목명</label></td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td><input type="submit" value="등록"></td>
			</tr>
		</table>
	</form>
	</section>
</body>
</html>