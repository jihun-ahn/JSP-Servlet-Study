<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="q05_regProduct.jsp" method="POST">
	<fieldset>
	<legend>제품 등록</legend>
		<label for="pname">상품명: </label>
		<input type="text" name="pname"><br>
		
		<label for="pcode">상품코드: </label>
		<input type="text" name="pcode"><br>
		
		<label for="price">가격: </label>
		<input type="text" name="price"><br>
		
		<label for="manu">제조사: </label>
		<input type="text" name="manu"><br>
		
		<label for="quantity">수량: </label>
		<input type="text" name="quantity"><br>
		
		<input type="submit" value="상품 등록">
		</fieldset>
	</form>
</body>
</html>