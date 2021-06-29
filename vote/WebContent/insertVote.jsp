<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.vote.dto.MemberDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>투표하기</title>
<link type="text/css" rel="stylesheet" href="css/vote.css">
<script type="text/javascript" src="script/vote.js"></script>
</head>
<body>
	<jsp:include page="./deco/header.jsp"/>
	<jsp:include page="./deco/nav.jsp"/>
	<section>
		<h1>투표하기</h1>
		<form action="InsertVote" method="POST" name="frm">
			<table border="1" id="tbl">
				<tr>
					<td>주민번호</td>
					<td><input type="text" name="v_jumin" id="v_jumin" size="25">&nbsp;<span>예 : 8906153154726</span></td>
				</tr>
				<tr>
					<td>성명</td>
					<td><input type="text" name="v_name" id="v_name"></td>
				</tr>
				<tr>
					<td>투표번호</td>
					<td>
						<select name="m_no" id="m_no">
							<option value="0">후보 선택</option>
							<%
								List<MemberDTO> memberList = (List)request.getAttribute("memberList");
								for(MemberDTO member:memberList){
									out.println("<option value="+member.getM_no()+">["+member.getM_no()+"] "+member.getM_name()+"</option>");
								}
							%>
						</select>
					</td>
				</tr>
				<tr>
					<td>투표시간</td>
					<td><input type="text" name="v_time" id="v_time"></td>
				</tr>
				<tr>
					<td>투표장소</td>
					<td><input type="text" name="v_area" id="v_area"></td>
				</tr>
				<tr>
					<td>유권자확인</td>
					<td><input type="radio" name="v_confirm" value="Y">확인&nbsp;&nbsp;<input type="radio" name="v_confirm" value="N">미확인</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="투표하기" onclick="return chk()">
						<input type="reset" value="다시하기" onclick="return ret()">
					</td>
				</tr>
			</table>
		</form>
	</section>
	<jsp:include page="./deco/footer.jsp"/>
</body>
</html>