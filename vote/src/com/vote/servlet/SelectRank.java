package com.vote.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vote.dao.VoteDAO;
import com.vote.dto.RankDTO;

/**
 * Servlet implementation class SelectRank
 */
@WebServlet("/SelectRank")
public class SelectRank extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "selectRankMember.jsp";
		
		VoteDAO dao = VoteDAO.getInstance();
		List<RankDTO> ranking = dao.selectRank();
		
		request.setAttribute("ranking", ranking);
				
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
