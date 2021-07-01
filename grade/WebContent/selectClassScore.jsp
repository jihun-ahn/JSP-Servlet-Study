<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="grade.dto.ScoreDTO" %>
<%@ page import="grade.dto.ScoreClassDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>클래스 성적 조회</title>
</head>
<body>
	<jsp:include page="include/header.jsp"/>
	<jsp:include page="include/nav.jsp"/>
	<section>
		<%
			List<ScoreDTO> list = (List)request.getAttribute("list");
			ScoreClassDTO classScore = (ScoreClassDTO)request.getAttribute("classScore");
			String s_class = (String)request.getAttribute("s_class");
		%>
	<h1><%=s_class %>반 성적 조회</h1>
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
		<% 
			for(ScoreDTO score:list){
				out.println("<tr>");
				out.println("<td>"+score.getName()+"</td>");
				out.println("<td>"+score.getKor()+"</td>");
				out.println("<td>"+score.getEng()+"</td>");
				out.println("<td>"+score.getMath()+"</td>");
				out.println("<td>"+score.getSci()+"</td>");
				out.println("<td>"+score.getSoc()+"</td>");
				out.println("<td>"+score.getTotal()+"</td>");
				out.println("<td>"+score.getAvg()+"</td>");
				out.println("</tr>");
			}
			out.println("<tr>");
			out.println("<td>*</td>");
			out.println("<td>국어 평균</td>");
			out.println("<td>영어 평균</td>");
			out.println("<td>수학 평균</td>");
			out.println("<td>과학 평균</td>");
			out.println("<td>사회 평균</td>");
			out.println("<td>총점 평균</td>");
			out.println("<td>전체 평균</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>"+classScore.getName()+"</td>");
			out.println("<td>"+classScore.getClass_kor()+"</td>");
			out.println("<td>"+classScore.getClass_eng()+"</td>");
			out.println("<td>"+classScore.getClass_math()+"</td>");
			out.println("<td>"+classScore.getClass_sci()+"</td>");
			out.println("<td>"+classScore.getClass_soc()+"</td>");
			out.println("<td>"+classScore.getClass_total()+"</td>");
			out.println("<td>"+classScore.getClass_avg()+"</td>");
			out.println("</tr>");
		%>
	</table>
	</section>
</body>
</html>