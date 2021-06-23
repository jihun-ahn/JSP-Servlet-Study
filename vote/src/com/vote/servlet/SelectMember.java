package com.vote.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vote.controller.Member;
import com.vote.dao.VoteDAO;
import com.vote.dto.MemberDTO;

@WebServlet("/SelectMember")
public class SelectMember extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "selectMember.jsp";
		
		VoteDAO dao = VoteDAO.getInstance();
		List<MemberDTO> memberList = dao.selectMember();
		List<MemberDTO> testList = Member.testMemberSelect(memberList);
		
		request.setAttribute("memberList", testList);
//		request.setAttribute("memberList", memberList);
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
