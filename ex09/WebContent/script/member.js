
function loginCheck(){
	if(document.frm.userid.value.length==0){
		alert('아이디를 입력해 주세요!');
		frm.userid.focus();
		return false;
	}
	if(document.frm.userpwd.value.length==0){
		alert('비밀번호를 입력해 주세요!');
		frm.userpwd.focus();
		return false;
	}
	
	return true;
}

function joinCheck(){
	// 이름 입력 여부
	if(document.frm.name.value.length==0){
		alert('이름을 입력해 주세요!');
		frm.name.focus();
		return false;
	}
	// 아이디 입력 여부
	if(document.frm.userid.value.length==0){
		alert('아이디를 입력해 주세요!');
		frm.userid.focus();
		return false;
	}
	// 암호 입력 여부
	if(document.frm.userpwd.value.length==0){
		alert('비밀번호를 입력해 주세요!');
		frm.userpwd.focus();
		return false;
	}
	// 입력된 암호 일치 여부
	if(document.frm.userpwd.value!=document.frm.pwd_check.value){
		alert('비밀번호가 일치하지 않습니다.');
		document.frm.userpwd.value = "";
		document.frm.pwd_check.value = "";
		
		frm.userpwd.focus();
		return false;
	}
	// 아이디 중복 체크 여부 (reid=??)
	if(document.frm.reid.value.length==0){
		alert('중복 체크를 하지 않았습니다.');
		frm.userid.focus();
		return false;
	}
	
	return true;
}

function idCheck(){
	if(document.frm.userid.value.length==0){
		alert('아이디를 입력해 주세요!');
		frm.userid.focus();
		return false;
	}
	var url = "idCheck.do?userid="+document.frm.userid.value;
	
	window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200");
	
}


function idOk(){
	opener.frm.userid.value = document.frm.userid.value;
	opener.frm.reid.value = document.frm.userid.value;
	
	self.close();	// 새로 열린창 종료
}