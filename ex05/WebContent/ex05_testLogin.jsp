<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userId = request.getParameter("userid");
	String userPwd = request.getParameter("userpwd");
	
	String id = "green";
	String pwd = "1234";
		
	if(userId.equals(id) && userPwd.equals(pwd)){
		session.setAttribute("id", id);
		session.setAttribute("pwd", pwd);
		RequestDispatcher rd = request.getRequestDispatcher("ex05_main.jsp");
		rd.forward(request, response);
	}else{
		response.sendRedirect("ex05_loginForm.jsp");	
	}
%>