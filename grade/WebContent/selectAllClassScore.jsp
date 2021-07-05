<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="grade.dto.ScoreClassDTO" %>
<%@ page import="grade.dto.SubjectVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>과목 조회</title>
<link rel="stylesheet" href="css/grade.css">
<script type="text/javascript" src="script/script.js"></script>
</head>
<body>
	<jsp:include page="include/header.jsp"/>
	<jsp:include page="include/nav.jsp"/>
	<section>
		<article>
			<%
				List<SubjectVO> subjectList = (List)request.getAttribute("subjectList");		// 과목 리스트
				List<ScoreClassDTO> classScore = (List)request.getAttribute("classScore");	// 반 평균
			%>
			<h1>전체 성적 조회</h1>
			<table class="score">
				<% 
					out.println("<tr>");
					out.println("<th>반</th>");
					for(SubjectVO subject:subjectList){	
						out.println("<th>"+subject.getName()+" 평균 "+"</th>");
					}
					out.println("<th>총점 평균</th>");
					out.println("<th>전체 평균</th>");
					out.println("</tr>");
					
					for(ScoreClassDTO class_one:classScore){
						out.println("<tr>");
						out.println("<td>"+class_one.getClass_name()+"</td>");
						for(double avg:class_one.getClass_avg()){
							out.println("<td>"+avg+"</td>");
						}
						out.println("<td>"+class_one.getTotal_avg()+"</td>");
						out.println("<td>"+class_one.getAll_avg()+"</td>");
						out.println("</tr>");
					}
					
				%>
			</table>
			<div class="button">
				<input type="button" value="과목 등록" onclick="location.href='InsertSubject'">
				<input type="button" value="뒤로가기" onclick="window.history.back()">
			</div>
		</article>
	</section>
	<jsp:include page="include/footer.jsp"/>
</body>
</html>