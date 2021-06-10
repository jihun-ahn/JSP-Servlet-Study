<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello JSP!! </h1>
	<%!
		public void a1(){
			System.out.println("에러");
		}
		int jumsu = 100; // 전역 변수(필드)
		
		public String str(){
			return "반가워요";
		}
	%>
	
	<%
		int num1 = 10;  //로컬 변수
		int num2 = 20;
		
		int add = num1+num2;
		
		//out.println("합계 : "+add);\
		out.println(num1+"+"+num2+"="+(num1+num2));
		//         10+20=30
	
		List<String> lists = new ArrayList<>();
		
		
	%>
	
	<!-- HTML 주석 : 누가 해석?? 웹브라우저 해석 : 클라이언트가 볼 수 있다-->
	<%
		// 스크립트릿 내부의 자바 주석
	%>
	
	<%-- 주석으로 동작 : 누가 해석?? WAS 해석  :  클라이언트가 볼 수 없다.--%>
	
	
	<!--  출력문 -->
	<%=num1 %>  <%--  out.println(num1); --%><br>
	<%=num1 %>+<%=num2 %>=<%=add %>
	<%=str() %>
	
	
</body>
</html>