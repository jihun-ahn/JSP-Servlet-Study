/**
 * 
 */
function chk(){
	if(!document.frm.v_jumin.value){
		alert("주민번호가 입력되지 않았습니다!");
		document.frm.v_jumin.focus();
		return false;
	}
	if(!document.frm.v_name.value){
		alert("성명이 입력되지 않았습니다!");
		document.frm.v_name.focus();
		return false;
	}
	if(document.frm.m_no.value=="0"){
		alert("후보번호가 입력되지 않았습니다!");
		document.frm.m_no.focus();
		return false;
	}
	if(!document.frm.v_time.value){
		alert("투표시간이 입력되지 않았습니다!");
		document.frm.v_time.focus();
		return false;
	}
	if(!document.frm.v_area.value){
		alert("투표장소가 입력되지 않았습니다!");
		document.frm.v_area.focus();
		return false;
	}
	if(!document.frm.v_confirm.value){
		alert("유권자확인이 선택되지 않았습니다!");
		return false;
	}
	alert("투표하기 정보가 정상적으로 등록 되었습니다!");
	return true;
}

function ret(){
	var cf = confirm("정보를 지우고 처음부터 다시 입력합니다!");
	if(cf){
		document.frm.v_jumin.focus();
	}
	return cf;
}