<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="grade.dto.ScoreDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개인 성적 조회</title>
</head>
<body>
	<jsp:include page="include/header.jsp"/>
	<jsp:include page="include/nav.jsp"/>
	<section>
	<% ScoreDTO dto = (ScoreDTO)request.getAttribute("dto"); %>
	<table border="1">
		<tr>
			<th>이름</th>
			<th>국어</th>
			<th>영어</th>
			<th>수학</th>
			<th>과학</th>
			<th>사회</th>
			<th>총점</th>
			<th>평균</th>
		</tr>
		<tr>
			<td><%=dto.getName() %></td>
			<td><%=dto.getKor() %></td>
			<td><%=dto.getEng() %></td>
			<td><%=dto.getMath() %></td>
			<td><%=dto.getSci() %></td>
			<td><%=dto.getSoc() %></td>
			<td><%=dto.getTotal() %></td>
			<td><%=dto.getAvg() %></td>
		</tr>
	</table>
	</section>
</body>
</html>