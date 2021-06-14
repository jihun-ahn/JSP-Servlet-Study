<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.DriverManager" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!
		Connection conn = null;
		PreparedStatement psmt = null;
		
		String url = "jdbc:oracle:thin:@localhost:1521:XE";		
		String uId = "greenJSP"; 								
		String uPw = "jsp1234";									
		
	%>
	<%			
		String sql = "DELETE FROM member WHERE userid='ahn'";
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
			conn = DriverManager.getConnection(url, uId, uPw);
			
			psmt = conn.prepareStatement(sql);
			
			int num = psmt.executeUpdate();
			System.out.println("바뀐 행의 갯수: "+num);
			
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			try{
				if(psmt!=null) {psmt.close();}
				if(conn!=null) {conn.close();}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	%>
</body>
</html>