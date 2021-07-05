<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="grade.dto.ScoreDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="grade.dto.SubjectVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개인 성적 조회</title>
<link rel="stylesheet" href="css/grade.css">
<script type="text/javascript" src="script/script.js"></script>
</head>
<body>
	<jsp:include page="include/header.jsp"/>
	<jsp:include page="include/nav.jsp"/>
	<section>
	<%
		ScoreDTO dto = (ScoreDTO)request.getAttribute("dto");
		List<SubjectVO> subjectList = (List)request.getAttribute("subjectList");
		
	%>
	<table class="score">
		<tr>
			<th>이름</th>
			<%
				for(SubjectVO subject:subjectList){	
					out.println("<th>"+subject.getName()+"</th>");
				}
			%>
			<th>총점</th>
			<th>평균</th>
		</tr>
		<tr>
			<td><%=dto.getName() %></td>
			<%
				for(int score:dto.getScores()){
					out.println("<td>"+score+"</td>");
				}
			%>			
			<td><%=dto.getTotal() %></td>
			<td><%=dto.getAvg() %></td>
		</tr>
	</table>
	<div class="button">
		<input type="button" value="뒤로가기" onclick="window.history.back()">
	</div>
	</section>
	<jsp:include page="include/footer.jsp"/>
</body>
</html>