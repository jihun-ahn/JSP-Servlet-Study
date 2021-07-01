<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
<script type="text/javascript" src="script/script.js"></script>
</head>
<body>
	<jsp:include page="include/header.jsp"/>
	<jsp:include page="include/nav.jsp"/>
	<section>
	<%
		session.removeAttribute("id");
	%>
	<form action="logIn" method="POST" name="frm">
		<table>
			<tr>
				<td><label for="id">아이디</label></td>
				<td><input type="text" name="id" id="id"></td>
				
				<td rowspan="2">
					<input type="submit" value="로그인" onclick="return loginChk()">
					<input type="button" value="회원가입" onclick="location.href='InsertSignUp'">
				</td>
			</tr>
			<tr>
				<td><label for="pwd">비밀번호</label></td>
				<td><input type="password" name="pwd" id="pwd"></td>
			</tr>
		</table>
	</form>
	</section>
</body>
</html>