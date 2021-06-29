<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="./script/jquery-3.6.0.js"></script>
</head>
<body>
	<h1>회원가입</h1>
	<form action="AjaxQuestion01">
		아이디 : <input type="text" name="userId" id="userId">
			<input type="button" value="ID중복체크" onclick="idChk()">&nbsp;<span id="msg"></span><br>
		이름 : <input type="text" name="userName" id="userName"><br>
		비밀번호 : <input type="password" name="userPwd" id="userPwd"><br>
			<input type="button" value="JSON 전송" onclick="jsonTransport()"><br>
		<input type="submit" value="확인">
		
	</form>
	<script type="text/javascript">

	function idChk(){  
		var req = new XMLHttpRequest();
	
		var userId = document.getElementById("userId").value;
	
		req.open("GET","AjaxQuestion01?userId="+userId);
		req.send(null);
		
	    req.onreadystatechange = function(){
	           if((req.readyState==4)&& (req.status==200)){
	                document.getElementById("msg").innerHTML = req.responseText;
	           }
	       };
	}
</script>
</body>
</html>