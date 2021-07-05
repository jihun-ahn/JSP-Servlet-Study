<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
<script type="text/javascript" src="script/script.js"></script>
<link rel="stylesheet" href="css/grade.css">
</head>
<body>
	<jsp:include page="include/header.jsp"/>
	<jsp:include page="include/nav.jsp"/>
	<section>
	<%
		session.removeAttribute("id");
	%>
		<article>
			<form action="logIn" method="POST" name="frm">
				<table>
					<thead>
						<tr>
							<td colspan="2"><h1>학생 / 선생님</h1></td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input type="text" name="id" id="id" placeholder="아이디를 입력하세요." size="30"></td>
							
							<td rowspan="2">
								<input type="submit" class="btn" value="로그인" onclick="return loginChk()">
								<input type="button" class="btn" value="회원가입" onclick="location.href='InsertSignUp'">
							</td>
						</tr>
						<tr>
							<td><input type="password" name="pwd" id="pwd" placeholder="비밀번호를 입력하세요." size="30"></td>
						</tr>
					</tbody>
				</table>
			</form>
		</article>
	</section>
	<jsp:include page="include/footer.jsp"/>
</body>
</html>