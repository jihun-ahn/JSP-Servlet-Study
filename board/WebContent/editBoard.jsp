<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.dto.BoardDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 수정</title>
<link rel="stylesheet" href="css/board.css">
</head>
<body>
	<jsp:include page="./include/header.jsp"></jsp:include>
	<%
		BoardDTO bDto = (BoardDTO)request.getAttribute("board");
	%>
	<section>
		<h1>게시물 수정</h1>
		<form action="EditBoard" method="POST">
			<table border="1">
				<tr>
					<td>작성자</td>
					<td>
						<input type="text" name="writer" value="<%=bDto.getWriter() %>">
						<input type="hidden" name="idx" value="<%=bDto.getIdx() %>">
					</td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" name="subject" value="<%=bDto.getSubject() %>"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea rows="10" cols="70" name="content"><%=bDto.getContent() %></textarea></td>
				</tr>
			</table>
			<div class="button">
				<input type="button" value="취소" onclick="location.href='SelectAllBoard'">
				<input type="submit" value="완료">
			</div>
		</form>
	</section>
	<jsp:include page="./include/footer.jsp"></jsp:include>
</body>
</html>