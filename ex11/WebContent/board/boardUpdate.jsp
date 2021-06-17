<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<link type="text/css" rel="stylesheet" href="css/board.css">
<body>
<div id="wrap" align="center">
	<h1>게시글 수정</h1>
	<form action="BS" method="POST">
		<input type="hidden" name="command" value="board_update">
		<input type="hidden" name="num" value="${board.num}">
		
		<table>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="name" value="${board.name}"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pass" value="${board.name}"></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="email" name="email" value="${board.email}"></td>
			</tr>
			<tr>
				<th>글제목</th>
				<td><input type="text" name="title" value="${board.title}"></td>
			</tr>
			
			<tr>
				<th>글내용</th>
				<td><textarea rows="15" cols="70" name="content">${board.content}</textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정">
					<input type="reset" value="다시 작성">
					<input type="button" value="목록 보기" onclick="location.href='BS?command=board_list'">
				</td>
			</tr>
			</table>
	</form>
</div>
</body>
</html>