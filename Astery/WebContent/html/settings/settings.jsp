<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>테스트</title>
<%request.getServletContext().getRealPath("/"); %>
</head>
<body>
    <jsp:include page="../include/header.jsp" />
    <section>
    	<aside></aside>
    	<article></article>
    	<aside></aside>
    </section>
    <jsp:include page="../include/footer.jsp" />
</body>
</html>