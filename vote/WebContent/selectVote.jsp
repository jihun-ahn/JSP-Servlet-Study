<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.vote.dto.VoteDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>투표검수조회</title>
</head>
<body>
	<section>
		<table>
			<%
				List<VoteDTO> voteList = (List<VoteDTO>)request.getAttribute("voteList");
				for(VoteDTO vote:voteList){
					String chk = "";
					if(vote.getV_confirm().equals("Y")){
						chk="확인";
					}else{
						chk="미확인";
					}
					out.println("<tr>");
					out.println("<td>"+vote.getV_name()+"</td>");
					out.println("<td>"/* 생년월일 */+"</td>");
					out.println("<td>"/* 나이 */+"</td>");
					out.println("<td>"/* 성별 */+"</td>");
					out.println("<td>"+vote.getM_no()+"</td>");
					out.println("<td>"+vote.getV_time()/* 변환 */+"</td>");
					out.println("<td>"+chk+"</td>");
					out.println("</tr>");
				}
			
			
			%>
		</table>
	</section>
</body>
</html>