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
	<% ScoreDTO dto = (ScoreDTO)request.getAttribute("dto"); %>
	<table>
		<tr>
			<th>이름</th>
			<th>국어 성적</th>
			<th>영어 성적</th>
			<th>수학 성적</th>
			<th>과학 성적</th>
			<th>사회 성적</th>
			<th>총 성적</th>
			<th>평균 성적</th>
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
</body>
</html>