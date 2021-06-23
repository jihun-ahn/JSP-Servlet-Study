package com.vote.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vote.controller.Vote;
import com.vote.dao.VoteDAO;
import com.vote.dto.TestDTO;
import com.vote.dto.VoteDTO;

/**
 * Servlet implementation class SelectVote
 */
@WebServlet("/SelectVote")
public class SelectVote extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "selectVote.jsp";
		
		VoteDAO dao = VoteDAO.getInstance();
		List<VoteDTO> voteList = dao.selectVote();
		List<TestDTO> testList = Vote.testVoteSelect(voteList);
		
		request.setAttribute("voteList", testList);
//		request.setAttribute("voteList", voteList);
		
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
