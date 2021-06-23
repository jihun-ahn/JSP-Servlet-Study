package com.vote.controller;

import java.util.List;

import com.vote.dto.MemberDTO;

public class Member {
	public static List<MemberDTO> testMemberSelect(List<MemberDTO> list){
		List<MemberDTO> memberList = list;
		for(MemberDTO member:memberList) {
			String grade = "";
			if(member.getP_school().equals("1")){
				grade = "고졸";
			}else if(member.getP_school().equals("2")){
				grade = "학사";
			}else if(member.getP_school().equals("3")){
				grade = "석사";
			}
			String jumin = member.getM_jumin().substring(0, 6)+"-"+member.getM_jumin().substring(6, 13);
			
			member.setP_school(grade);
			member.setM_jumin(jumin);
		}
		
		return memberList;
	}
}
