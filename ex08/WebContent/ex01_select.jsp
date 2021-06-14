<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.DriverManager" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터베이스 조회</title>
</head>
<body>
	<%!
		// 선언부는 첫 방문자에 의해서 한번만 수행
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;									// 쿼리가 select문 일 경우 필요
		
		String url = "jdbc:oracle:thin:@localhost:1521:XE";		// 서버 주소+포트+sid
		String uId = "greenJSP"; 								// 접속 계정
		String uPw = "jsp1234";									// 접속 계정의 비밀번호
		
		String sql = "SELECT * FROM member";
	%>
	
	<table border="1">
		<tr>
			<td>이름</td>
			<td>아이디</td>
			<td>암호</td>
			<td>이메일</td>
			<td>전화번호</td>
			<td>권한(0:일반회원, 1:관리자)</td>
		</tr>	
			<%
		try{
			// 1단계 : 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
			// 2단계 : 데이터베이스 연결
			conn = DriverManager.getConnection(url, uId, uPw);		// 서버주소, 계정, 비밀번호
			
			// 3단계 : 쿼리문 실행할 객체 생성
			stmt = conn.createStatement();
			
			// 4단계 : 쿼리문 실행
			rs = stmt.executeQuery(sql);							// 읽어오기(R)를 위한 쿼리(메서드) 리턴값이 여러개의 레코드
			//stmt.executeUpdate(sql);								// 기록, 변경, 삭제(CUD)을 위한 쿼리(메서드) 리턴값이 정수
			
			// 5단계 : 데이터 꺼내서 출력
			while(rs.next()){
				out.println("<tr>");
				out.println("<td>"+rs.getString("name")+"</td>");
				out.println("<td>"+rs.getString("userid")+"</td>");
				out.println("<td>"+rs.getString("userpwd")+"</td>");
				out.println("<td>"+rs.getString("email")+"</td>");
				out.println("<td>"+rs.getString("phone")+"</td>");
				out.println("<td>"+rs.getInt("admin")+"</td>");
				out.println("</tr>");
			}
		}catch(Exception e){
			e.printStackTrace();	// 예외 발생 추적
			
		}finally{
			try{
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				if(conn!=null) {conn.close();}
			}catch(Exception e){
				e.printStackTrace();
			}
		}

	%>
	</table>


</body>
</html>