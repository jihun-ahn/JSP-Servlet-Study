<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="grade.dto.UserDTO" %>
<nav>
<%
	UserDTO dto = (UserDTO)session.getAttribute("dto");
	if(dto!=null){
%>
	<ul>
		<li><%=dto.getName() %>(<%=dto.getId() %>)님 환영합니다.</li>
		<li><input type="button" value="로그아웃" onclick="location.href='LogOut'"></li>
	</ul>
<%
	} 
%>
</nav>
