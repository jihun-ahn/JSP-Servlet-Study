<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!   //선언문
	String storedId = "green";
	String storedPassword = "1234";

%>

	<%
		request.setCharacterEncoding("UTF-8");  // 한글 깨짐 방지
	
		String userId = request.getParameter("userid");	
		System.out.println("이름 : "+userId);
	    String userPassword = request.getParameter("userpassword");	

	    if(userId.equals(storedId) && userPassword.equals(storedPassword)){
	%>
	<h1><%=userId %>님 로그인 성공 하셨습니다.</h1>
	 
	<%
	    }else{
	%>  	
	<h1>아이디 또는 비밀번호가 틀렸습니다.</h1>
	<%
	    }
	%>
	
	
	
	<!--  if(조건){
	    조건이 true
	}else{
	   조건이 false
	} -->

</body>
</html>



