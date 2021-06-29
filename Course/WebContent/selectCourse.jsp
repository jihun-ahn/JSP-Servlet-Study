<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="course.dto.CourseDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>교과목 목록</title>
<link rel="stylesheet" href="css/course.css">
</head>
<body>
	<jsp:include page="include/header.jsp"></jsp:include>
	<section>
		<table border="1">
			<tr>
				<th>과목코드</th>
				<th>과목명</th>
				<th>학점</th>
				<th>담당강사</th>
				<th>요일</th>
				<th>시작시간</th>
				<th>종료시간</th>
				<th>관리</th>
			</tr>
			<%
				List<CourseDTO> courseList = (List)request.getAttribute("courseList");
				for(CourseDTO course : courseList){
					out.println("<tr>");
					out.println("<td>"+course.getId()+"</td>");
					out.println("<td>"+course.getName()+"</td>");
					out.println("<td>"+course.getCredit()+"</td>");
					out.println("<td>"+course.getLecturer()+"</td>");
					out.println("<td>"+course.getWeek()+"</td>");
					out.println("<td>"+course.getStart_hour()+"</td>");
					out.println("<td>"+course.getEnd_hour()+"</td>");
					out.println("<td>"+"<a href='ReviseCourse?id="+course.getId()+"'>수정</a>"+" / "+"<a href='DeleteCourse?id="+course.getId()+"'>삭제</a>"+"</td>");
					out.println("</tr>");
				}
			%>
		</table>
		<div class="button">
			<input type="button" value="작성" id="write" onclick="location.href='InsertCourse'">
		</div>
	</section>
	<jsp:include page="include/footer.jsp"></jsp:include>
</body>
</html>