<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 등록</title>
<link type="text/css" rel="stylesheet" href="css/movie.css">
</head>
<body>
<div id="wrap">
	<h1>영화 등록</h1>
	<form action="IS" method="POST" enctype="multipart/form-data">
	<input type="hidden">
	<table>
		<tr>
			<th>포스터</th>
			<td><input type="file" name="imageurl" required></td>
			
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" name="title" required></td>
		</tr>
		<tr>
			<th>감독</th>
			<td><input type="text" name="director" required></td>
		</tr>
		<tr>
			<th>배우</th>
			<td><input type="text" name="actor" required></td>
		</tr>
		<tr>
			<th>제작비</th>
			<td><input type="number" name="cost" required></td>
		</tr>
		<tr>
			<th>평점</th>
			<td><input type="number" name="score" step="0.01" required></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="등록">
				<input type="button" value="목록으로 돌아가기" onclick="location.href='MS?command=movie_list'">
			</td>
		</tr>
	</table>
	</form>
</div>
</body>
</html>