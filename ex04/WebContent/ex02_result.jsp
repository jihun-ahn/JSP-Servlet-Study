<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("username");
	%>
		이름 : <%=name%><br>
	<%
		String gender = request.getParameter("gender");
	%>
	성별 : 
	<%
		if(gender.equals("male")){
			gender="남성";
		}else{
			gender="여성";
		}
	%>
	<%=gender%><br>


	좋아하는 계절 : <br>
	<%
		String[] season = request.getParameterValues("season");
		for(String s:season){
			switch(s){
			case "spring":
				out.println("봄입니다.");
				break;
			case "summer":
				out.println("여름입니다.");
				break;
			case "fall":
				out.println("가을입니다.");
				break;
			case "winter":
				out.println("겨울입니다.");
				break;
			
			}
		}
	%>
	
	
</body>
</html>