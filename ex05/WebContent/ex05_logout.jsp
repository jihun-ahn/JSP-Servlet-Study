<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%
		session.removeAttribute("id");
		session.removeAttribute("pwd");
	%>
	<script>
		alert('로그아웃 되었습니다.');
		location.href="ex05_loginForm.jsp";
	</script>
