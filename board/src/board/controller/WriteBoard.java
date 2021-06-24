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
import board.dto.WriteDTO;

/**
 * Servlet implementation class WriteBoard
 */
@WebServlet("/WriteBoard")
public class WriteBoard extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "writeBoard.jsp";		
			
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		Timestamp now = new Timestamp(System.currentTimeMillis());
		WriteDTO wDto = new WriteDTO();
		wDto.setWriter(request.getParameter("writer"));
		wDto.setSubject(request.getParameter("writer"));
		wDto.setContent(request.getParameter("writer"));
		wDto.setDate(now);
		
		BoardDAO dao = BoardDAO.getInstance();
		dao.writeBoard(wDto);
		
		response.sendRedirect("SelectAllBoard");
	}

}
