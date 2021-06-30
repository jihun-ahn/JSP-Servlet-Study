package grade.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import grade.dao.GradeDAO;
import grade.dto.ScoreDTO;
import grade.dto.ScoreVO;

/**
 * Servlet implementation class SelectScore
 */
@WebServlet("/SelectScore")
public class SelectScore extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="selectScore.jsp";
		String name = request.getParameter("name");
		
		GradeDAO dao = GradeDAO.getInstance();
		ScoreVO sVo = dao.selectTargetScore(name);
		ScoreDTO dto = new ScoreDTO();
		dto.setName(sVo.getName());
		dto.setKor(sVo.getKor());
		dto.setEng(sVo.getEng());
		dto.setMath(sVo.getMath());
		dto.setSci(sVo.getSci());
		dto.setSoc(sVo.getSoc());
		int total = sVo.getKor()+sVo.getEng()+sVo.getMath()+sVo.getSci()+sVo.getSoc();		
		dto.setTotal(total);
		double avg = total/5.0;		
		dto.setAvg(avg);
		request.setAttribute("dto", dto);
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
