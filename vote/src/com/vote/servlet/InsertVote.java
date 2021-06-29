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
import com.vote.dto.MemberDTO;
import com.vote.dto.VoteDTO;


@WebServlet("/InsertVote")
public class InsertVote extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "insertVote.jsp";
		
		VoteDAO dao = VoteDAO.getInstance();
		List<MemberDTO> list = dao.selectMember();
		
		request.setAttribute("memberList", list);
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String url = "index.jsp";
		
		VoteDTO vDto = new VoteDTO();
		vDto.setV_jumin(request.getParameter("v_jumin"));
		vDto.setV_name(request.getParameter("v_name"));
		vDto.setM_no(request.getParameter("m_no"));
		vDto.setV_time(request.getParameter("v_time"));
		vDto.setV_area(request.getParameter("v_area"));
		vDto.setV_confirm(request.getParameter("v_confirm"));
		VoteDAO dao = VoteDAO.getInstance();
		dao.insertVote(vDto);
		
		response.sendRedirect(url);
	}

}
