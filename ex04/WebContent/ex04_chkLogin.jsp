<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder" %>
<%
	request.setCharacterEncoding("UTF-8");
	String id = "green";
	String pwd = "1234";
	String name = "최서희";
	String userId = request.getParameter("userid");
	String userPwd = request.getParameter("userpassword");
	
	
	if(id.equals(userId) && pwd.equals(userPwd)){
		//response.sendRedirect("ex04_main.jsp?=name"+URLEncoder.encode(name,"UTF-8"));
		request.setAttribute("name", name);
		
		//forward방식
		RequestDispatcher rd = request.getRequestDispatcher("ex04_main.jsp");
		rd.forward(request, response);
	}else{
		response.sendRedirect("ex04_loginfail.jsp");
	}
%>