<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 등록</title>
<link type="text/css" rel="stylesheet" href="css/member.css">
</head>
<body>
	<section>
		<form action="InsertServlet" method="POST">
			<table>
				<tr>
					<th><label for="custno">회원번호(자동생성)</label></th>
					<td><input type="number" name="custno" value="${lastCustno}"></td>
				</tr>
				<tr>
					<th><label for="custname">회원성명</label></th>
					<td><input type="text" name="custname" ></td>
				</tr>
				<tr>
					<th><label for="phone">회원전화</label></th>
					<td><input type="tel" name="phone"></td>
				</tr>
				<tr>
					<th><label for="address">회원주소</label></th>
					<td><input type="text" name="address" ></td>
				</tr>
				<tr>
					<th><label for="joindate">가입일자</label></th>
					<td><input type="" name="joindate" ></td>
				</tr>
				<tr>
					<th><label for="grade">고객등급 [A:VIP, B:일반, C:직원]</label></th>
					<td><input type="text" name="grade"></td>
				</tr>
				<tr>
					<th><label for="city">도시코드</label></th>
					<td><input type="text" name="city"></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="등록">
						<input type="button" value="조회" onclick="location.href='SelectAllServlet'">
					</td>
				</tr>
			</table>
		</form>
	</section>
</body>
</html>