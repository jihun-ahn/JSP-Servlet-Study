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
		// 선언부는 첫 방문자에 의해서 한번만 수행
		Connection conn = null;
		PreparedStatement psmt = null;
		
		String url = "jdbc:oracle:thin:@localhost:1521:XE";		// 서버 주소+포트+sid
		String uId = "greenJSP"; 								// 접속 계정
		String uPw = "jsp1234";									// 접속 계정의 비밀번호
		
	%>
	<%	
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String userid = request.getParameter("userId");
		String userpwd = request.getParameter("userPwd");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		int grade = Integer.parseInt(request.getParameter("grade"));
		
		String sql = "INSERT INTO member VALUES(?,?,?,?,?,?)";
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
			conn = DriverManager.getConnection(url, uId, uPw);
			
			psmt = conn.prepareStatement(sql);			// 미리 쿼리문(미완성)을 넣는다.
			
			// 미완성의 쿼리문을 채워야 한다.
			psmt.setString(1, name);
			psmt.setString(2, userid);
			psmt.setString(3, userpwd);
			psmt.setString(4, email);
			psmt.setString(5, phone);
			psmt.setInt(6, grade);
			
			// 쿼리문 실행 => 매개값을 넣지 않는다.
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