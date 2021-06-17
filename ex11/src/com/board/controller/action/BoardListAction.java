package com.board.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.BoardDAO;
import com.board.vo.BoardVO;

public class BoardListAction implements Action {	// 서블릿처럼 동작 (doGet 처럼 동작)

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// 실질적으로 게시물 리스트를 가져와서 뷰에 연결해주는 메서드
		
		String url = "board/boardList.jsp";
		
		BoardDAO dao = BoardDAO.getInstance();
		List<BoardVO> boardList = dao.selectAllBoards();
		
		request.setAttribute("boardList", boardList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
