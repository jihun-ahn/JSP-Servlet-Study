<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>세션에 저장된 모든 값 읽어오기</h3>
	<%
		Enumeration<String> names = session.getAttributeNames(); // 세션에 저장된 속성 값의 모든 이름을 읽어오는 메서드
		while(names.hasMoreElements()){
			String name = names.nextElement().toString();	// 세션에 젖아된 속성의 이름을 순서대로 읽어온다.
			String value = session.getAttribute(name).toString();
			
			out.println(name+": "+value+"<br>");
		}
	%>
</body>
</html>