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
<table border="1">
	<tr>
		<td>상품 리스트</td>
	</tr>

	<%	
		String link = "<a href='?pname=${}'>";
		Enumeration<String> pnames = session.getAttributeNames(); // 세션에 저장된 속성 값의 모든 이름을 읽어오는 메서드
		while(pnames.hasMoreElements()){
			String pname = pnames.nextElement().toString();	// 세션에 젖아된 속성의 이름을 순서대로 읽어온다.
			
			out.println("<tr><td>"+pname+"</a></td></tr>");
		}
	%>
</table>
<form action=""></form>
</body>
</html>