<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생조회</title>
<link rel="stylesheet" href="css/grade.css">
</head>
<body>
	<jsp:include page="include/header.jsp"/>
	<jsp:include page="include/nav.jsp"/>
	<section>
		<table>
			<%
				List<String> nameList = (List)request.getAttribute("nameList");
				out.println("<tr>");
				for(String name:nameList){
					out.println("<td><a href='SelectScore?name="+name+"'>"+name+"</a></td>");
				}
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