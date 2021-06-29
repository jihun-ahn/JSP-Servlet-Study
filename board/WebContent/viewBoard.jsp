<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.dto.BoardVO" %>
<%@ page import="board.dto.CommentVO" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 조회</title>
<link rel="stylesheet" href="css/board.css">
</head>
<body>
	<jsp:include page="./include/header.jsp"></jsp:include>
	<section>
	<%
		BoardVO bVo = (BoardVO)request.getAttribute("board");
		List<CommentVO> commentList = (List)request.getAttribute("commentList");
	%>
		<article>
			<h1>게시물 조회</h1>
			<p>제목: <%=bVo.getSubject() %></p>
			<p><span>작성자: <%=bVo.getWriter() %></span> <span>작성일: <%=bVo.getDate() %></span></p><br>
			<p><%=bVo.getContent() %></p>
		</article>
		<article>
			<p>댓글 조회</p>
			<%
				for(CommentVO comment:commentList){
					out.println("<p>"+comment.getWriter()+" / "+comment.getContent()+" / "+comment.getDate()+" /"+"<a href='DeleteComment?idx="+comment.getIdx()+"&bidx="+comment.getBidx()+"'>삭제</a>"+"</p>");
				}
			%>
		</article>
		<article>
			<form action="ViewBoard" method="POST">
				<p>댓글 작성</p>
				<input type="hidden" name="bidx" value="<%=bVo.getIdx() %>">
				<label for="writer">작성자 : </label>
				<input type="text" name="writer"><br>
				<label for="content">댓글 : </label>
				<input type="text" name="content" size="50"><input type="submit" value="작성완료">
			</form>
		</article>
		<div class="button" id="view">
			<a href="SelectAllBoard"><input type="button" value="목록"></a>
			<a href="EditBoard?idx=<%=bVo.getIdx() %>"><input type="button" value="수정"></a>
			<a href="DeleteBoard?idx=<%=bVo.getIdx() %>"><input type="button" value="삭제"></a>
		</div>
	</section>
	<jsp:include page="./include/footer.jsp"></jsp:include>
</body>
</html>