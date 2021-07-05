<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>과목 등록</title>
<script type="text/javascript" src="script/script.js"></script>
<link rel="stylesheet" href="css/grade.css">
</head>

<body>
	<jsp:include page="include/header.jsp"/>
	<jsp:include page="include/nav.jsp"/>
	<section>
	<form action="InsertSubject" method="POST">
		<table>
			<tr>
				<td><label for="id">과목 id</label></td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td><label for="name">과목명</label></td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: right">
					<input type="submit" value="등록">
					<input type="button" value="뒤로가기" onclick="window.history.back()">
				</td>
			</tr>
		</table>
	</form>
	</section>
	<jsp:include page="include/footer.jsp"/>
</body>
</html>