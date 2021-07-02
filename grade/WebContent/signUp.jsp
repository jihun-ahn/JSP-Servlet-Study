<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="css/grade.css">
</head>
<body>
	<jsp:include page="include/header.jsp"/>
	<jsp:include page="include/nav.jsp"/>
	<section>
	<form action="InsertSignUp" method="POST">
		<table border="1">
			<tr>
				<td><label for="id">아이디</label></td>
				<td><input type="text" name="id" id="id"></td>
			</tr>
			<tr>
				<td><label for="name">이름</label></td>
				<td><input type="text" name="name" id="name"></td>
			</tr>
			<tr>
				<td><label for="pwd">비밀번호</label></td>
				<td><input type="password" name="pwd" id="pwd"></td>
			</tr>
			<tr>
				<td><label for="u_class">반</label></td>
				<td><input type="text" name="u_class" id="u_class"></td>
			</tr>
			<tr>
				<td><label for="job">직업</label></td>
				<td>
					<input type="radio" name="job" value="teacher">선생
					<input type="radio" name="job" value="student">학생
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="회원가입">
				</td>
			</tr>
		</table>
	</form>
	</section>
</body>
</html>