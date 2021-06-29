package board.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDAO;
import board.dto.BoardDTO;
import board.dto.BoardVO;

/**
 * Servlet implementation class SelectAllBoard
 */
@WebServlet("/SelectAllBoard")
public class SelectAllBoard extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "selectBoard.jsp";
		
		BoardDAO dao = BoardDAO.getInstance();
		
		List<BoardDTO> list = dao.selectAllBoard();
		List<BoardVO> boardList = new ArrayList<>();
		int lastNum = 0;
		for(BoardDTO board:list) {
			BoardVO bVo = new BoardVO();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd kk:mm");
			String date = format.format(board.getT_date());
			
			bVo.setIdx(board.getIdx());
			bVo.setWriter(board.getWriter());
			bVo.setSubject(board.getSubject());
			bVo.setContent(board.getContent());
			bVo.setDate(date);
			
			lastNum += 1;
			boardList.add(bVo);
		}
		
		
		request.setAttribute("boardList", boardList);
		request.setAttribute("lastNum", lastNum);
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
