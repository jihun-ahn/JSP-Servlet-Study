<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.green.beans.Member" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		com.green.beans.Member m1 = new com.green.beans.Member();
		Member m2 = new Member();
		m1.setName("고길동");
		m1.setUserId("ko");
		session.setAttribute("member1", m1);
		
		
		//(Member)session.getAttribute("member1");
	%>
	
	이름 : <%=m1.getName() %><br>
	아이디 : <%=m1.getUserId() %><br>
	
	<jsp:useBean class="com.green.beans.Member" id="m3" scope="session"/>
	<%
			
	
	%>
</body>
</html>








