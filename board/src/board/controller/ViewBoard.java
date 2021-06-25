package board.controller;

import java.io.IOException;
import java.sql.Timestamp;
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
import board.dto.CommentDTO;
import board.dto.CommentVO;

/**
 * Servlet implementation class ViewBoard
 */
@WebServlet("/ViewBoard")
public class ViewBoard extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "viewBoard.jsp";
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		BoardDAO dao = BoardDAO.getInstance();
		
		// 글 정보 가공
		BoardDTO board = dao.selectTargetBoard(idx);
		BoardVO bVo = new BoardVO();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd kk:mm");
		String date = format.format(board.getT_date());
			
		bVo.setIdx(board.getIdx());
		bVo.setWriter(board.getWriter());
		bVo.setSubject(board.getSubject());
		bVo.setContent(board.getContent());
		bVo.setDate(date);
		
		
		
		// 댓글 정보 가공
		List<CommentDTO> list = dao.selectComment(idx);
		List<CommentVO> commentList = new ArrayList<>();
		for(CommentDTO comment:list) {
			CommentVO cVo = new CommentVO();
			String c_date = format.format(comment.getT_date());
			
			cVo.setIdx(comment.getIdx());
			cVo.setBidx(comment.getIdx());
			cVo.setWriter(comment.getWriter());
			cVo.setContent(comment.getContent());
			cVo.setDate(c_date);
			commentList.add(cVo);
		}
		
		
		request.setAttribute("board", bVo);
		request.setAttribute("commentList", commentList);
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.setCharacterEncoding("UTF-8");
		CommentDTO cDto = new CommentDTO();
		Timestamp now = new Timestamp(System.currentTimeMillis());
		
		cDto.setBidx(Integer.parseInt(request.getParameter("bidx")));
		cDto.setWriter(request.getParameter("writer"));
		cDto.setContent(request.getParameter("content"));
		cDto.setT_date(now);
		
		BoardDAO dao = BoardDAO.getInstance();
		dao.writeComment(cDto);
		
		response.sendRedirect("ViewBoard?idx="+Integer.parseInt(request.getParameter("bidx")));
	}

}
