package com.vote.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.vote.dto.TestDTO;
import com.vote.dto.VoteDTO;

public class Vote {
	public static List<TestDTO> testVoteSelect(List<VoteDTO> list){
		List<VoteDTO> voteList = list;
		List<TestDTO> testList = new ArrayList<>();
		for(VoteDTO vote:voteList) {
			String chk = "";
			if(vote.getV_confirm().equals("Y")){
				chk="확인";
			}else{
				chk="미확인";
			}
			Date now = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			
			SimpleDateFormat b = new SimpleDateFormat("yyyy년MM월dd일");
			Date jumin = null;
			String century = "";
			if(vote.getV_jumin().substring(6, 7).equals("3") || vote.getV_jumin().substring(6, 7).equals("4")) {
				century = "20";
			}else if (vote.getV_jumin().substring(6, 7).equals("1") || vote.getV_jumin().substring(6, 7).equals("2")) {
				century = "19";
			}
			try {
				jumin = format.parse(century+vote.getV_jumin().substring(0,6));
			}catch(Exception e) {
				e.printStackTrace();
			}
			String birth = b.format(jumin); 
			
			int num = Integer.parseInt(format.format(now));
			int age = ((num-Integer.parseInt(format.format(jumin)))/10000);
								
			String gender = "";
			if(vote.getV_jumin().substring(6, 7).equals("1") || vote.getV_jumin().substring(6, 7).equals("3")){
				gender="남";
			}else if(vote.getV_jumin().substring(6, 7).equals("2") || vote.getV_jumin().substring(6, 7).equals("4")){
				gender="여";
			}
			String time = vote.getV_time().substring(0, 2)+":"+vote.getV_time().substring(2, 4);			
			
			TestDTO tDto = new TestDTO();
			tDto.setName(vote.getV_name());
			tDto.setBirth(birth);
			tDto.setAge(age);
			tDto.setGender(gender);
			tDto.setVoteNum(vote.getM_no());
			tDto.setTime(time);
			tDto.setChk(chk);
			
			testList.add(tDto);
		}
		return testList;
	}
}
