<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.green.dao.MemberDAO" %>
<%@ page import="java.sql.Connection" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>DBCP 연동 테스트 페이지</h3>
	<%
		MemberDAO dao = MemberDAO.getInstance();
		Connection conn = dao.getConnection();
		
		if(conn != null){
			out.println("DBCP 연동 성공");
		}else{
			out.println("DBCP 연동 성공");
		}
	
	%>
</body>
</html>