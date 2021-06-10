<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.green.beans.Member" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% request.setCharacterEncoding("UTF-8"); %>
	<%-- 1. 자바빈 객체 생성 --%>
<%
	// 방법 1. 스크립트릿에서 자바빈 생성
	Member member1 = new Member();
	session.setAttribute("member1", member1);
	
	// 방법 2. 액션 태그로 자바빈 생성
%>
	<jsp:useBean class="com.green.beans.Member" id="member2"></jsp:useBean>

	<%-- 2. 데이터 입력 --%>
<%
	// 방법 1
	String name = request.getParameter("name");
	String nickName = request.getParameter("nickName");
	String userId = request.getParameter("userId");
	String userPw = request.getParameter("userPw");
	String email = request.getParameter("email");
	String phone = request.getParameter("phone");

	member1.setName(name);
	member1.setNickName(nickName);
	member1.setUserId(userId);
	member1.setUserPw(userPw);
	member1.setEmail(email);
	member1.setPhone(phone);
	
	// 방법 2(=방법 1)
	//member1.setName(request.getParameter("name"));
	//member1.setNickName(request.getParameter("nickName"));
	//member1.setUserId(request.getParameter("userId"));
	//member1.setUserPw(request.getParameter("userPw"));
	//member1.setEmail(request.getParameter("email"));
	//member1.setPhone(request.getParameter("phone"));
%>

<%-- 방법 3 - 액션태그 --%>
<%--
	<jsp:setProperty name="member2" property="name" value='<%=request.getParameter("name")%>'/>
	<jsp:setProperty name="member2" property="nickName" value='<%=request.getParameter("nickName")%>'/>
	<jsp:setProperty name="member2" property="userId" value='<%=request.getParameter("userId")%>'/>
	<jsp:setProperty name="member2" property="userPw" value='<%=request.getParameter("userPw")%>'/>
	<jsp:setProperty name="member2" property="email" value='<%=request.getParameter("email")%>'/>
	<jsp:setProperty name="member2" property="phone" value='<%=request.getParameter("phone")%>'/>
--%>
	
<%-- 방법 4 - 액션태그 --%>
<%--	
	<jsp:setProperty name="member2" property="name"/>
	<jsp:setProperty name="member2" property="nickName"/>
	<jsp:setProperty name="member2" property="userId"/>
	<jsp:setProperty name="member2" property="userPw"/>
	<jsp:setProperty name="member2" property="email"/>
	<jsp:setProperty name="member2" property="phone"/>
	
--%>

<%-- 방법 4 - 액션태그 --%>
	<jsp:setProperty name="member2" property="*"/>
<%-- 3. 데이터 출력 --%>
<%-- 방법 1 --%>
	이름 	:<%=member1.getName() %><br>
	아이디 	:<%=member1.getUserId() %><br>
	별명 	:<%=member1.getNickName() %><br>
	비밀번호 	:<%=member1.getUserPw() %><br>
	이메일 	:<%=member1.getEmail() %><br>
	전화번호 	:<%=member1.getPhone() %>
	<hr>
<%-- 방법 2 액션태그 --%>
	이름		:<jsp:getProperty property="name" name="member2"/><br>
	아이디	:<jsp:getProperty property="userId" name="member2"/><br>
	별명		:<jsp:getProperty property="nickName" name="member2"/><br>
	비밀번호	:<jsp:getProperty property="userPw" name="member2"/><br>
	이메일	:<jsp:getProperty property="email" name="member2"/><br>
	전화번호	:<jsp:getProperty property="phone" name="member2"/><br>
	
</body>
</html>