	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 등록</title>
<link type="text/css" rel="stylesheet" href="css/board.css">
</head>
<body>
<div id="wrap" align="center">
	<h1>게시글 등록</h1>
	<hr>
	<p>*는 필수 입력 항목</p>
	<form action="BS" method="POST">
		<input type="hidden" name="command" value="board_write">
		<table>
			<tr>
				<th>작성자</th>
				<td>*<input type="text" name="name" required></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>*<input type="password" name="pass" required><br>(게시물 수정, 삭제시 필요)</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="email" name="email" ></td>
			</tr>
			<tr>
				<th>글 제목</th>
				<td>*<input type="text" name="title" required></td>
			</tr>
			<tr>
				<th>본문</th>
				<td><textarea rows="15" cols="70" name="content" ></textarea> </td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="글 작성">
					<input type="reset" value="다시 작성">
					<input type="button" value="목록으로 돌아가기" onclick="location.href='BS?command=board_list'">
				</td>
				
			</tr>
		</table>
		
		
	</form>
</div>
</body>
</html>