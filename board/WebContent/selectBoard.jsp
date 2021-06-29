<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="board.dto.BoardVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 보기</title>
<link rel="stylesheet" href="css/board.css">
</head>
<body>
	<jsp:include page="./include/header.jsp"></jsp:include>
	<section>
		<h2> 총 <%=request.getAttribute("lastNum")%>개의 게시물이 있습니다. </h2>
		<table border="1">
			<tr>
				<th>번호</th>
				<th>작성자</th>
				<th>제목</th>
				<th>작성일</th>
			</tr>
			<%
				List<BoardVO> boardList = (List)request.getAttribute("boardList");
				for(BoardVO board:boardList){
					out.println("<tr>");
					out.println("<td>"+board.getIdx()+"</td>");
					out.println("<td>"+board.getWriter()+"</td>");
					out.println("<td class='subject'><a href='ViewBoard?idx="+board.getIdx()+"'>"+board.getSubject()+"</a></td>");
					out.println("<td>"+board.getDate()+"</td>");					
					out.println("</tr>");
				}
			%>
		</table>
		<div class="button">
			<input type="button" value="작성" id="write" onclick="location.href='WriteBoard'">
		</div>
	</section>
	<jsp:include page="./include/footer.jsp"></jsp:include>
</body>
</html>