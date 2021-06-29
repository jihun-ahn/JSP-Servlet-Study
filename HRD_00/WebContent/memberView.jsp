<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
<link type="text/css" rel="stylesheet" href="css/member.css">
<script type="text/javascript" src="script/member.js" ></script>
</head>
<body>
	<jsp:include page="./deco/header.jsp"></jsp:include>
	<jsp:include page="./deco/nav.jsp"></jsp:include>
	<section>
		<form action="MemberView" method="POST">
			<table border="1">
				<tr>
					<th><label for="custno">회원번호</label></th>
					<td><input type="number" name="custno" value="${member.custno}" readonly></td>
				</tr>
				<tr>
					<th><label for="custname">회원성명</label></th>
					<td><input type="text" name="custname" value="${member.custname}"></td>
				</tr>
				<tr>
					<th><label for="phone">회원전화</label></th>
					<td><input type="tel" name="phone" value="${member.phone}"></td>
				</tr>
				<tr>
					<th><label for="address">회원주소</label></th>
					<td><input type="text" name="address" value="${member.address}"></td>
				</tr>
				<tr>
					<th><label for="joindate">가입일자</label></th>
					<td><input type="text" name="joindate" value="${member.joindate}"></td>
				</tr>
				<tr>
					<th><label for="grade">고객등급 [A:VIP, B:일반, C:직원]</label></th>
					<td><input type="text" name="grade" value="${member.grade}"></td>
				</tr>
				<tr>
					<th><label for="city">도시코드</label></th>
					<td><input type="text" name="city" value="${member.city}"></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="수정">
						<input type="button" value="조회" onclick="location.href='SelectAllServlet'">
					</td>
				</tr>
			</table>
		</form>
	</section>
	<jsp:include page="./deco/footer.jsp"></jsp:include>
</body>
</html>