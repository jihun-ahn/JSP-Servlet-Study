<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.green.answer.Product" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	
	Product product = (Product)session.getAttribute(request.getParameter("pname"));
	String pname = product.getPname();
	String pcode = product.getPcode();
	String price = product.getPrice();
	String manu = product.getManu();
	String quantity = product.getQuantity();
%>
	상품명	:<%=pname %><br>
	상품코드	:<%=pcode %><br>
	가격		:<%=price %><br>
	제조사	:<%=manu %><br>
	수량		:<%=quantity %><br>
</body>
</html>