<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.vote.dto.RankDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후보자 등수</title>
<link type="text/css" rel="stylesheet" href="css/vote.css">
</head>
<body>
	<jsp:include page="./deco/header.jsp"/>
	<jsp:include page="./deco/nav.jsp"/>
	<section>
		<table border="1">
			<tr>
				<td>후보번호</td>
				<td>성명</td>
				<td>총투표건수</td>
			</tr>
			<%
				List<RankDTO> ranking = (List<RankDTO>)request.getAttribute("ranking");
				for(RankDTO rank : ranking){
					out.println("<tr>");
					out.println("<td>"+rank.getM_no()+"</td>");
					out.println("<td>"+rank.getM_name()+"</td>");
					out.println("<td>"+rank.getVote()+"</td>");
					out.println("</tr>");
				}
			
			%>
		</table>
	</section>
	<jsp:include page="./deco/footer.jsp"/>
</body>
</html>