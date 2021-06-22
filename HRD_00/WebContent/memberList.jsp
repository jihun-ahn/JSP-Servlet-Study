	<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.hrd.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.Timestamp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록 조회/수정</title>
<link type="text/css" rel="stylesheet" href="css/member.css">
</head>
<body>
	<jsp:include page="./deco/header.jsp"></jsp:include>
	<jsp:include page="./deco/nav.jsp"></jsp:include>
	<section>
		<table border="1">
			<tr>
				<th>회원번호</th>
				<th>회원성명</th>
				<th>전화번호</th>
				<th>주소</th>
				<th>가입일자</th>
				<th>고객등급</th>
				<th>거주지역</th>
			</tr>
			<%
				List<MemberVO> memberList = (List<MemberVO>)request.getAttribute("memberList");
				for(MemberVO member:memberList){
					String grade = "";
					if(member.getGrade().equals("A")){
						grade = "VIP";
					}else if(member.getGrade().equals("B")){
						grade = "일반";
					}else if(member.getGrade().equals("C")){
						grade = "직원";
					}
					String joindate = new SimpleDateFormat("yyyy-MM-dd").format(member.getJoindate());
					out.println("<tr>");
					out.println("<td><a href='MemberView?custno="+member.getCustno()+"'>"+member.getCustno()+"</a></td>");
					out.println("<td>"+member.getCustname()+"</td>");
					out.println("<td>"+member.getPhone()+"</td>");
					out.println("<td>"+member.getAddress()+"</td>");
					out.println("<td>"+joindate+"</td>");
					out.println("<td>"+member.getGrade()+"</td>");
					out.println("<td>"+member.getCity()+"</td>");
					out.println("</tr>");
				}
			%>
		</table>
	</section>
	<jsp:include page="./deco/footer.jsp"></jsp:include>
</body>
</html>