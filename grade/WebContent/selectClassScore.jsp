<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="grade.dto.ScoreDTO" %>
<%@ page import="grade.dto.ScoreClassDTO" %>
<%@ page import="grade.dto.SubjectVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>클래스 성적 조회</title>
<link rel="stylesheet" href="css/grade.css">
<script type="text/javascript" src="script/script.js"></script>
</head>
<body>
	<jsp:include page="include/header.jsp"/>
	<jsp:include page="include/nav.jsp"/>
	<section>
		<%
			List<ScoreDTO> list = (List)request.getAttribute("list");
			ScoreClassDTO classScore = (ScoreClassDTO)request.getAttribute("classScore");
			String s_class = (String)request.getAttribute("s_class");
			List<SubjectVO> subjectList = (List)request.getAttribute("subjectList");
		%>
	<h1><%=s_class%>반 성적 조회</h1>
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
		<%
			for(ScoreDTO scoreList:list){
				out.println("<tr>");
				out.println("<td>"+scoreList.getName()+"</td>");
				for(int score:scoreList.getScores()){
					out.println("<td>"+score+"</td>");	
				}
				out.println("<td>"+scoreList.getTotal()+"</td>");
				out.println("<td>"+scoreList.getAvg()+"</td>");
				out.println("</tr>");
			}
			out.println("<tr>");
			out.println("<th>반</th>");
			for(SubjectVO subject:subjectList){	
				out.println("<th>"+subject.getName()+" 평균 "+"</th>");
			}
			out.println("<th>총점 평균</th>");
			out.println("<th>전체 평균</th>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>"+classScore.getClass_name()+"</td>");
			for(double avg:classScore.getClass_avg()){
				out.println("<td>"+avg+"</td>");
			}
			out.println("<td>"+classScore.getTotal_avg()+"</td>");
			out.println("<td>"+classScore.getAll_avg()+"</td>");
			out.println("</tr>");
		%>
	</table>
	<div class="button">
		<input type="button" value="뒤로가기" onclick="window.history.back()">
	</div>
	</section>
	<jsp:include page="include/footer.jsp"/>
</body>
</html>