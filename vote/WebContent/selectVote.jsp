<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<!--  <%@ page import="com.vote.dto.VoteDTO" %> -->
<%@ page import="com.vote.dto.TestDTO" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>투표검수조회</title>
<link type="text/css" rel="stylesheet" href="css/vote.css">
</head>
<body>
	<jsp:include page="./deco/header.jsp"/>
	<jsp:include page="./deco/nav.jsp"/>
	<section>
		<h1>투표검수조회</h1>
		<table border="1">
			<tr>
				<td>성명</td>
				<td>생년월일</td>
				<td>나이</td>
				<td>성별</td>
				<td>후보번호</td>
				<td>투표시간</td>
				<td>유권자확인</td>
			</tr>
			<%
				List<TestDTO> voteList = (List<TestDTO>)request.getAttribute("voteList");
				for(TestDTO vote:voteList){

					out.println("<tr>");
					out.println("<td>"+vote.getName()+"</td>");
					out.println("<td>"+vote.getBirth()+"</td>");
					out.println("<td>"+"만 "+vote.getAge()+"세"+"</td>");
					out.println("<td>"+vote.getGender()+"</td>");
					out.println("<td>"+vote.getVoteNum()+"</td>");
					out.println("<td>"+vote.getTime()+"</td>");
					out.println("<td>"+vote.getChk()+"</td>");
					out.println("</tr>");
				}
			
			
			%>
		</table>
	</section>
	<jsp:include page="./deco/footer.jsp"/>
</body>
</html>