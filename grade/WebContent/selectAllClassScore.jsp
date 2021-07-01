<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="grade.dto.ScoreClassDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>과목 조회</title>
</head>
<body>
	<jsp:include page="include/header.jsp"/>
	<jsp:include page="include/nav.jsp"/>
	<section>
	<%
		List<ScoreClassDTO> list = (List)request.getAttribute("list");
		ScoreClassDTO classScore = (ScoreClassDTO)request.getAttribute("classScore");
		String s_class = (String)request.getAttribute("s_class");
		if(s_class!=null){
	%>
			<h1><%=s_class %>반 성적 조회</h1>
	<%
		}
	%>
	
	<table border="1">
		<tr>
			<th>반</th>
			<th>국어</th>
			<th>영어</th>
			<th>수학</th>
			<th>과학</th>
			<th>사회</th>
			<th>총점</th>
			<th>평균</th>
		</tr>
		<% 
			for(ScoreClassDTO score:list){
				out.println("<tr>");
				out.println("<td>"+score.getName()+"</td>");
				out.println("<td>"+score.getClass_kor()+"</td>");
				out.println("<td>"+score.getClass_eng()+"</td>");
				out.println("<td>"+score.getClass_math()+"</td>");
				out.println("<td>"+score.getClass_sci()+"</td>");
				out.println("<td>"+score.getClass_soc()+"</td>");
				out.println("<td>"+score.getClass_total()+"</td>");
				out.println("<td>"+score.getClass_avg()+"</td>");
				out.println("</tr>");
			}
		%>
	</table>
	<input type="button" value="과목 등록" onclick="location.href='InsertSubject'">
	</section>
</body>
</html>