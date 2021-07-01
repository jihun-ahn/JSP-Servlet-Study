package grade.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import grade.dao.GradeDAO;
import grade.dto.ScoreClassDTO;
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
		request.setCharacterEncoding("UTF-8");
		String url = "selectClassScore.jsp";
		
		String s_class = request.getParameter("s_class");
		GradeDAO dao = GradeDAO.getInstance();
		List<ScoreVO> list = dao.selectAllScore(s_class);
		List<ScoreDTO> scoreList = new ArrayList<>();
		ScoreClassDTO classScore = new ScoreClassDTO(s_class);
		int total = 0;
		double avg = 0;
		
		for(ScoreVO sVo:list) {
			ScoreDTO dto = new ScoreDTO();
			dto.setName(sVo.getName());
			dto.setKor(sVo.getKor());
			dto.setEng(sVo.getEng());
			dto.setMath(sVo.getMath());
			dto.setSci(sVo.getSci());
			dto.setSoc(sVo.getSoc());
			total = sVo.getKor()+sVo.getEng()+sVo.getMath()+sVo.getSci()+sVo.getSoc();
			dto.setTotal(total);
			avg = total/5.0;
			dto.setAvg(avg);
			scoreList.add(dto);
			
			classScore.setClass_kor(classScore.getClass_kor()+sVo.getKor());
			classScore.setClass_eng(classScore.getClass_eng()+sVo.getEng());
			classScore.setClass_math(classScore.getClass_math()+sVo.getMath());
			classScore.setClass_sci(classScore.getClass_sci()+sVo.getSci());
			classScore.setClass_soc(classScore.getClass_soc()+sVo.getSoc());
			
		}
		double size = (double)scoreList.size();
		classScore.setClass_kor(classScore.getClass_kor()/size);
		classScore.setClass_eng(classScore.getClass_eng()/size);
		classScore.setClass_math(classScore.getClass_math()/size);
		classScore.setClass_sci(classScore.getClass_sci()/size);
		classScore.setClass_soc(classScore.getClass_soc()/size);
		
		classScore.setClass_total(classScore.getClass_kor()+classScore.getClass_eng()+classScore.getClass_math()+classScore.getClass_sci()+classScore.getClass_soc());
		classScore.setClass_avg(classScore.getClass_total()/5);
		
		request.setAttribute("list", scoreList);
		request.setAttribute("classScore", classScore);
		request.setAttribute("s_class", s_class);
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
