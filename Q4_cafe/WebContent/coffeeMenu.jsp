<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커피 메뉴 선택 페이지</title>
</head>
<body>
	<h3>커피 메뉴 선택 페이지</h3>
	
	<form action="CM" method="POST">
		<select name="coffeeName">
			<c:forEach var="coffeeName" items="${coffeeNames}">
				<option value="${coffeeName}">${coffeeName}</option>
			</c:forEach>
		</select>
		<select name="coffeeType">
			<option value="톨">톨</option>
			<option value="그란데">그란데</option>
			<option value="벤티">벤티</option>
		</select>
		<input type="number" name="coffeeCount">잔
		<input type="submit" value="선택">
	</form>
	<hr>
	<table border="1">
		<tr>
			<th>커피</th>
			<th>타입</th>
			<th>가격</th>
			<th>개수</th>
			<th>합계</th>
		</tr>
		<c:forEach var="CoffeeVoList" items="${CoffeeVoList}">
		<tr>
			<td> ${CoffeeVoList.coffeeName} </td>
			<td> ${CoffeeVoList.coffeeType} </td>
			<td> ${CoffeeVoList["coffeePrice"]} </td>
			<td> ${CoffeeVoList["coffeeCount"]} </td>
			<td> ${CoffeeVoList.coffeeCount * CoffeeVoList.coffeePrice} </td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>