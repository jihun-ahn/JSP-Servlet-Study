<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder" %>
<%
	String[] admin = {"admin", "1234"};
	String[] user = {"user", "5678"};
	
	String inputId = request.getParameter("userId");
	String inputPassword = request.getParameter("userPassword");
	
	if(admin[0].equals(inputId) && admin[1].equals(inputPassword)){ // 관리자 로그인
%>
<jsp:forward page="ex07_adminMain.jsp">
	<jsp:param value='<%=URLEncoder.encode("관리자", "UTF-8") %>' name="name"/>
</jsp:forward>
<%
} else if(user[0].equals(inputId) && user[1].equals(inputPassword)){
%>
<jsp:forward page="ex07_userMain.jsp">
	<jsp:param value='<%=URLEncoder.encode("고객", "UTF-8") %>' name="name"/>
</jsp:forward>
<%
}else{ // 로그인 실패
%>
<script type="text/javascript">
	alert('로그인 실패: 아이디 또는 비밀번호가 틀립니다.');
	history.go(-1);
</script>

<%
}
%>