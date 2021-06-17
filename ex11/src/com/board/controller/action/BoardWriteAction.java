package com.board.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.BoardDAO;
import com.board.vo.BoardVO;

public class BoardWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardVO bVo = new BoardVO();
		BoardDAO dao = BoardDAO.getInstance();
		
		bVo.setName(request.getParameter("name"));
		bVo.setEmail(request.getParameter("email"));
		bVo.setPass(request.getParameter("pass"));
		bVo.setTitle(request.getParameter("title"));
		bVo.setContent(request.getParameter("content"));
		
		dao.insertBoard(bVo);
		
		response.sendRedirect("BS?command=board_list");
	}

}
