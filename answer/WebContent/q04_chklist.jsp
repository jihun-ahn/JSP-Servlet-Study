<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String[] chk = request.getParameterValues("chklist");
	if(chk==null){
		response.sendRedirect("q04_negative.jsp");
	}else{
		int rand = (int)(Math.random()*100+1);
		if(rand%2==0){
			response.sendRedirect("q04_positive.jsp");
		}else{
			response.sendRedirect("q04_negative.jsp");
		}
	}

%>