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
import javax.servlet.http.HttpSession;

import grade.dao.GradeDAO;
import grade.dto.ClassVO;
import grade.dto.ScoreClassDTO;
import grade.dto.SubjectVO;
import grade.dto.UserDTO;


@WebServlet("/SelectTeacher")
public class SelectTeacher extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//과목조회
		String url = "selectAllClassScore.jsp";
		GradeDAO dao = GradeDAO.getInstance();
		
		List<SubjectVO> subjectList = dao.selectAllSubject();
		List<ClassVO> classList = dao.selectClass();
		List<ScoreClassDTO> list = new ArrayList<>();
		
		for(ClassVO cVo:classList) {
			ScoreClassDTO classScore = ClassScore.getClassScore(cVo.getT_class());
			list.add(classScore);
		}
		
		request.setAttribute("subjectList", subjectList);
		request.setAttribute("classScore", list);// List<ScoreClassDTO>
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//학생조회
		request.setCharacterEncoding("UTF-8");
		String url = "selectStudent.jsp";
		
		HttpSession session = request.getSession();
		UserDTO dto = (UserDTO)session.getAttribute("dto");
		GradeDAO dao = GradeDAO.getInstance();
		List<String> nameList = dao.selectClassStudent(dto.getU_class());
		
		request.setAttribute("nameList",nameList);
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
