<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table *{
		text-align: center;
	}
</style>
</head>
<body>
	<table border="1">
		<tr>
			<th>커피 명</th>
			<th>톨</th>
			<th>그란데</th>
			<th>벤티</th>
		</tr>
		<tr>
			<td>돌체 라떼</td>
			<td>5600</td>
			<td>6100</td>
			<td>6600</td>
		</tr>
		<tr>
			<td>화이트 초콜릿 모카</td>
			<td>5600</td>
			<td>6100</td>
			<td>6600</td>			
		</tr>
		<tr>
			<td>카페 모카</td>
			<td>5100</td>
			<td>5600</td>
			<td>6100</td>			
		</tr>
		<tr>
			<td>카페 라떼</td>
			<td>4600</td>
			<td>5100</td>
			<td>5600</td>			
		</tr>
		<tr>
			<td>아메리카노</td>
			<td>4100</td>
			<td>4600</td>
			<td>5100</td>			
		</tr>
		<tr>
			<td>오늘의 커피</td>
			<td>3800</td>
			<td>4300</td>
			<td>4800</td>			
		</tr>
		<tr>
			<td>블론드 바닐라 더블샷 마키야또</td>
			<td>5600</td>
			<td>6100</td>
			<td>6600</td>			
		</tr>
	</table>
	<form action="q06_result.jsp" method="POST">
		<select name="name">
			<option value="dolche">돌체 라떼
			<option value="whitemoca">화이트 초콜릿 모카
			<option value="moca">카페 모카
			<option value="latte">카페 라떼
			<option value="americano">아메리카노
			<option value="today">오늘의 커피
			<option value="blond">블론드 바닐라 더블샷 마키야또
		</select>
		<select name="size">
			<option value="0">톨
			<option value="1">그란데
			<option value="2">벤티
		</select>
		<input type="text" name="num" placeholder="잔">
		<input type="submit" value="선택">
	</form>
</body>
</html>