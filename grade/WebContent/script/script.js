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