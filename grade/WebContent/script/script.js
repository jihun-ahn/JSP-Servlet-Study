/**
 * 
 */
function loginChk(){
	if(!document.frm.id.value){
		alert('아이디가 입력되지않았습니다.');
		document.frm.id.focus();
		return false;
	}
	if(!document.frm.pwd.value){
		alert('비밀번호가 입력되지않았습니다.');
		document.frm.pwd.focus();
		return false;
	}
	return true;
}

function signUpChk(){
	if(!document.frm.id.value){
		alert('아이디가 입력되지않았습니다.');
		document.frm.id.focus();
		return false;
	}
	if(!document.frm.name.value){
		alert('이름이 입력되지않았습니다.');
		document.frm.name.focus();
		return false;
	}
	if(!document.frm.pwd.value){
		alert('비밀번호가 입력되지않았습니다.');
		document.frm.pwd.focus();
		return false;
	}
	if(!document.frm.u_class.value){
		alert('직업이 입력되지않았습니다.');
		document.frm.u_class.focus();
		return false;
	}
	return true;
}