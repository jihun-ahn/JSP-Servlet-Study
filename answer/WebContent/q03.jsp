<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	List<String> result = (List<String>)request.getAttribute("result");
%>
<table border="1">
	<tr>
		<%
			for(String dan:result){
				out.println("<td>"+dan+"</td>");
				
			}
		%>	
	</tr>
</table>
</body>
</html>