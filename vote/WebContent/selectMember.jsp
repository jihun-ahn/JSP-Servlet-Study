<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.vote.dto.MemberDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후보 조회</title>
</head>
<body>
	<section>
		<table>
			<%
				List<MemberDTO> memberList = (List<MemberDTO>)request.getAttribute("memberList");
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
</body>
</html>