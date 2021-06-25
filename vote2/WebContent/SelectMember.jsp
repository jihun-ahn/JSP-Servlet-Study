<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dao.VoteDAO" %>
<%@ page import="com.vote.dto.MemberVO" %>
<%@ page import="com.vote.dto.MemberDTO" %>
<%@ page import="javax.servlet.RequestDispatcher" %>
<%
	VoteDAO dao = VoteDAO.getInstance();
	List<MemberVO> list = (List)dao.selectAllMember();

	List<MemberDTO> memberList = new ArrayList<>();
	for(MemberVO vo:list){
		MemberDTO dto = new MemberDTO();
		
		dto.setM_no(vo.getM_no());
		dto.setM_name(vo.getM_name());
		dto.setP_name(vo.getP_name());
		dto.setM_city(vo.getM_city());
		
		String school= null;
		if(vo.getP_school().equals("1")){
			school = "고졸";
		}else if(vo.getP_school().equals("2")){
			school = "학사";
		}else if(vo.getP_school().equals("3")){
			school = "석사";
		}else if(vo.getP_school().equals("4")){
			school = "박사";
		}
		
		dto.setP_school(school);
		
		String jumin = vo.getM_jumin().substring(0, 6)+"-"+vo.getM_jumin().substring(6);
		dto.setM_jumin(jumin);
		
		String tel = vo.getP_tel1().trim()+"-"+vo.getP_tel2()+"-"+vo.getP_tel3();
		dto.setP_tel(tel);
		
		memberList.add(dto);
	}
	
	request.setAttribute("memberList", memberList);
	
	RequestDispatcher rd = request.getRequestDispatcher("MemberView.jsp");
	rd.forward(request, response);
%>