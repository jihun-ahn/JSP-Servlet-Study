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
	// request 객체에 값 저장
	
	request.setAttribute("num1", 10);
	request.setAttribute("num2", 20);

%>
<h3>표현식에서 합계</h3>
<%=(int)request.getAttribute("num1") %> +
<%=(Integer)request.getAttribute("num2") %>
= <%= (int)request.getAttribute("num1")+(Integer)request.getAttribute("num2") %>
<hr>
<h3>표현식에서 합계 2</h3>
<%
	int num1 = (Integer)request.getAttribute("num1");
	int num2 = (Integer)request.getAttribute("num2");
%>
<%=num1 %> + <%=num2 %> = <%=num1+num2 %>
<hr>
<h3>El 표기법에서의 합계</h3>
${num1} + ${num2} = ${num1+num2}<br>
</body>
</html>