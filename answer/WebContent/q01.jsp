<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 
	국어점수 : <%=request.getAttribute("score1") %><br>
	영어점수 : <%=request.getAttribute("score2") %><br>
	수학점수 : <%=request.getAttribute("score3") %><br>
	총점 : <%=request.getAttribute("sumScore") %><br>
	평균 : <%=request.getAttribute("avg") %><br> 
--%>
	
	국어점수 : <%=session.getAttribute("score1") %><br>
	영어점수 : <%=session.getAttribute("score2") %><br>
	수학점수 : <%=session.getAttribute("score3") %><br>
	총점 : <%=session.getAttribute("sumScore") %><br>
	평균 : <%=session.getAttribute("avg") %><br>
	
</body>
</html>