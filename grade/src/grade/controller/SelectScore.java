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
import grade.dto.SubjectVO;

@WebServlet("/SelectScore")
public class SelectScore extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="selectScore.jsp";
		String name = request.getParameter("name");
		
		GradeDAO dao = GradeDAO.getInstance();
		List<SubjectVO> subjectList = dao.selectAllSubject();
		int subjectNum = subjectList.size();
		ScoreVO sVo = dao.selectTargetScore(name, subjectNum);
		ScoreDTO dto = new ScoreDTO();
		List<Integer> scores = new ArrayList<>();
		dto.setName(sVo.getName());
		int total = 0;
		for(int score:sVo.getScores()) {
			total +=score;
			scores.add(score);
		}
		dto.setScores(scores);
		dto.setTotal(total);
		double avg = Math.round(10*total/(double)subjectNum)/10.0;		
		dto.setAvg(avg);
		
		request.setAttribute("dto", dto);
		request.setAttribute("subjectList", subjectList);
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String url = "selectClassScore.jsp";
		
		String s_class = request.getParameter("s_class");				// 반 이름
		
		GradeDAO dao = GradeDAO.getInstance();
		List<SubjectVO> subjectList = dao.selectAllSubject();			// 전체 과목
		int subjectNum = dao.selectAllSubject().size();						// 과목 갯수
		List<ScoreVO> list = dao.selectAllScore(s_class, subjectNum);	// 반 학생 정보 리스트
		List<ScoreDTO> scoreList = new ArrayList<>();					// 표현 될 정보를 저장 할 리스트
		ScoreClassDTO classScore = new ScoreClassDTO(s_class);			// 전체 반 평균을 저장할 리스트
		int total = 0;
		double avg = 0;
		double total_avg = 0;
		double all_avg = 0;
		double subjectTotalScore = 0;
		List<Integer> scores = new ArrayList<>();		// 모든 점수가 저장 될 리스트
		List<Double> avgList = new ArrayList<>();		// 과목별 평균점수가 저장 될 리스트
		for(ScoreVO sVo:list) {							// DB에서 뽑아온 정보를 가공하기 위한 for문
			List<Integer> studentScore = new ArrayList<>();
			ScoreDTO dto = new ScoreDTO();
			dto.setName(sVo.getName());
			for(int score:sVo.getScores()) {
				total += score;
				studentScore.add(score);
				scores.add(score);
			}
			dto.setScores(studentScore);
			dto.setTotal(total);
			total_avg+=total;
			avg = Math.round(10*total/subjectNum)/10.0;
			all_avg+=avg;
			dto.setAvg(avg);
			total=0;
			scoreList.add(dto);
		}
		avg=0;
		for(int i=0;i<subjectNum;i++) {											// 각 과목별  평균을 저장하기 위한 for문
			for(int j=i;j<scores.size();j+=subjectNum) {						// 과목끼리 나누기위한 for문
				subjectTotalScore+=scores.get(j);								// 과목별 총점
			}
			subjectTotalScore= Math.round(10*subjectTotalScore/list.size())/10.0;			// 총점/과목갯수
			avgList.add(subjectTotalScore);										// 평균 저장
			subjectTotalScore=0;
		}
		total_avg= Math.round(10*total_avg/list.size())/10.0;
		all_avg=Math.round(10*all_avg/list.size())/10.0;
		
		classScore.setClass_name(s_class);
		classScore.setClass_avg(avgList);
		classScore.setTotal_avg(total_avg);
		classScore.setAll_avg(all_avg);
		
		request.setAttribute("list", scoreList);			// List<ScoreDTO>
		request.setAttribute("classScore", classScore);		// ScoreClassDTO
		request.setAttribute("s_class", s_class);			// String
		request.setAttribute("subjectList", subjectList);
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
