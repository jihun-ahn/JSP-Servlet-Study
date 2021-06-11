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
	Product product = new Product();
	product.setPname(request.getParameter("pname"));
	product.setPcode(request.getParameter("pcode"));
	product.setPrice(request.getParameter("price"));
	product.setManu(request.getParameter("manu"));
	product.setQuantity(request.getParameter("quantity"));
	
	session.setAttribute(request.getParameter("pname"), product);
	
	response.sendRedirect("q05_productList.jsp");
%>
</body>
</html>