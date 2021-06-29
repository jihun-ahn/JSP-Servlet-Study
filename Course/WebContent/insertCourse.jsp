<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>교과목 추가</title>
</head>
<link rel="stylesheet" href="css/course.css">
<body>
	<jsp:include page="include/header.jsp"></jsp:include>
	<section>
		<form action="InsertCourse" method="POST">
			<table border="1">
				<tr>
					<td>교과목 코드</td>
					<td align="left"><input type="text" name="id" size="50%" required></td>
				</tr>
				<tr>
					<td>과목명</td>
					<td align="left"><input type="text" name="name" size="50%" required></td>
				</tr>
				<tr>
					<td>담당강사</td>
					<td align="left">
						<select name="lecturer">
							<option value="0">담당강사선택</option>
							<option value="1">김교수</option>
							<option value="2">이교수</option>
							<option value="3">박교수</option>
							<option value="4">우교수</option>
							<option value="5">최교수</option>
							<option value="6">강교수</option>
							<option value="7">황교수</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>학점</td>
					<td align="left"><input type="text" name="credit" size="50%" required></td>
				</tr>
				<tr>
					<td>요일</td>
					<td class="radio" align="left">
						&nbsp;<input type="radio" name="week" value="1">&nbsp;월
						&nbsp;<input type="radio" name="week" value="2">&nbsp;화
						&nbsp;<input type="radio" name="week" value="3">&nbsp;수
						&nbsp;<input type="radio" name="week" value="4">&nbsp;목
						&nbsp;<input type="radio" name="week" value="5">&nbsp;금
						&nbsp;<input type="radio" name="week" value="6">&nbsp;토
					</td>
				</tr>
				<tr>
					<td>시작</td>
					<td align="left"><input type="text" name="start_hour" size="50%" required></td>
				</tr>
				<tr>
					<td>종료</td>
					<td align="left"><input type="text" name="end_hour" size="50%" required></td>
				</tr>
			</table>
			<div class="button">
				<input type="button" value="목록" onclick="location.href='SelectAllCourse'">
				<input type="submit" value="완료">
			</div>
		</form>
	</section>
	<jsp:include page="include/footer.jsp"></jsp:include>
</body>
</html>