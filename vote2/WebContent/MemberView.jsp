<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.vote.dto.MemberDTO" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/vote.css">
</head>
<body>
	<jsp:include page="./deco/header.jsp"/>
	<jsp:include page="./deco/nav.jsp"/>
	<%
		List<MemberDTO> memberList = (List)request.getAttribute("memberList");
	%>
	<section>
		<table border="1">
			<tr>
				<td>후보번호</td>
				<td>성명</td>
				<td>소속정당</td>
				<td>학력</td>
				<td>주민번호</td>
				<td>지역구</td>
				<td>대표전화</td>
			</tr>
			<%
				for(MemberDTO member : memberList){
					out.println("<tr>");
					out.println("<td>"+member.getM_no()+"</td>");
					out.println("<td>"+member.getM_name()+"</td>");
					out.println("<td>"+member.getP_name()+"</td>");
					out.println("<td>"+member.getP_school()+"</td>");
					out.println("<td>"+member.getM_jumin()+"</td>");
					out.println("<td>"+member.getM_city()+"</td>");
					out.println("<td>"+member.getP_tel()+"</td>");
					out.println("</tr>");
				}
			%>
		</table>
	</section>
	<jsp:include page="./deco/footer.jsp"/>	
</body>
</html>