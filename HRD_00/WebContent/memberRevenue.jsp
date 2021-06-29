<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.hrd.vo.RevenueVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원매출조회</title>
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
				<th>고객등급</th>
				<th>매출</th>
			</tr>
			<%
				List<RevenueVO> revenueList = (List<RevenueVO>)request.getAttribute("revenueList");
				for(RevenueVO revenue:revenueList){
					String grade = "미등록";
					if(revenue.getGrade().equals("A")){
						grade = "VIP";
					}else if(revenue.getGrade().equals("B")){
						grade = "일반";
					}else if(revenue.getGrade().equals("C")){
						grade = "직원";
					}
					out.println("<tr>");
					out.println("<td>"+revenue.getCustno()+"</td>");
					out.println("<td>"+revenue.getCustname()+"</td>");
					out.println("<td>"+revenue.getGrade()+"</td>");
					out.println("<td>"+revenue.getPrice()+"</td>");
					out.println("</tr>");
				}
			%>
		</table>
	</section>
	<jsp:include page="./deco/footer.jsp"></jsp:include>
</body>
</html>