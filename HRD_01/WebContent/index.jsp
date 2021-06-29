<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
<link type="html/css" rel="stylesheet"  href="css/member.css">
</head>
<body>
	<jsp:include page="./deco/header.jsp"></jsp:include>
	<jsp:include page="./deco/nav.jsp"></jsp:include>
	<section class="section">
		<h3>쇼핑몰 회원관리 프로그램</h3>
		<p>쇼핑몰 회원 정보와 회원 매출 정보 데이터베이스를 구축하고 회원 관리 프로그램을 작성하는 프로그램이다.<br>
			프로그램 작성 순서
		</p>
		<ol>
			<li>회원 정보 테이블을 생성한다.</li>
			<li>매출 정보 테이블을 생성한다.</li>
			<li>회원정보, 매출정보 테이블에 제시된 문제지의 참조데이터를 추가 생성한다.</li>
			<li>회원정보 입력 화면프로그램을 작성한다.</li>
			<li>회원정보 조회 프로그램을 작성한다.</li>
			<li>회원매출정보 조회 프로그램을 작성한다.</li>
		</ol>
		</section>
	<jsp:include page="./deco/footer.jsp"></jsp:include>
</body>
</html>