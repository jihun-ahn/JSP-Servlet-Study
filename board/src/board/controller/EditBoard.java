package board.controller;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDAO;
import board.dto.BoardDTO;
import board.dto.WriteDTO;

@WebServlet("/EditBoard")
public class EditBoard extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "editBoard.jsp";
		int idx = Integer.parseInt(request.getParameter("idx"));
		BoardDAO dao = BoardDAO.getInstance();
		BoardDTO bDto = dao.selectEditBoard(idx);
		
		request.setAttribute("board", bDto);
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int idx = Integer.parseInt(request.getParameter("idx"));
		String url= "ViewBoard?idx="+idx;
		
		Timestamp now = new Timestamp(System.currentTimeMillis());
		WriteDTO wDto = new WriteDTO();
		wDto.setWriter(request.getParameter("writer"));
		wDto.setSubject(request.getParameter("subject"));
		wDto.setContent(request.getParameter("content"));
		wDto.setDate(now);
		
		BoardDAO dao = BoardDAO.getInstance();
		dao.editBoard(wDto, idx);
		
		response.sendRedirect(url);
	}

}
