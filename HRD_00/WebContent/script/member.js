/**
 * 
 */

function chk(){
	if(!document.frm.custname.value){
		alert("회원 성명을 입력하세요.");
		document.frm.custname.focus
		return false;	
	}
	if(!document.frm.phone.value){
		alert("회원 전화를 입력하세요.");
		document.frm.phone.focus
		return false;	
	}
	if(!document.frm.address.value){
		alert("회원 주소를 입력하세요.");
		document.frm.address.focus
		return false;	
	}
	if(!document.frm.joindate.value){
		alert("가입 일자를 입력하세요.");
		document.frm.joindate.focus
		return false;	
	}
	if(!document.frm.grade.value){
		alert("고객 등급을 입력하세요.");
		document.frm.grade.focus
		return false;	
	}if(!document.frm.city.value){
		alert("도시 코드를 입력하세요.");
		document.frm.city.focus
		return false;	
	}
	return true;
}