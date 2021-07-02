package grade.controller;

import java.util.ArrayList;
import java.util.List;

import grade.dao.GradeDAO;
import grade.dto.ScoreClassDTO;
import grade.dto.ScoreDTO;
import grade.dto.ScoreVO;

public class ClassScore {
	
	public static ScoreClassDTO getClassScore(String u_class) {
		
		GradeDAO dao = GradeDAO.getInstance();
		int subjectNum = dao.getSubjectNumber();						// 과목 갯수
		List<ScoreVO> list = dao.selectAllScore(u_class, subjectNum);	// 반 학생 정보 리스트
		ScoreClassDTO classScore = new ScoreClassDTO(u_class);			// 전체 반 평균을 저장할 리스트
		int total = 0;
		double avg = 0;
		double total_avg = 0;
		double all_avg = 0;
		double subjectTotalScore = 0;
		List<Integer> scores = new ArrayList<>();		// 모든 점수가 저장 될 리스트
		List<Double> avgList = new ArrayList<>();		// 과목별 평균점수가 저장 될 리스트
		for(ScoreVO sVo:list) {							// DB에서 뽑아온 정보를 가공하기 위한 for문
			for(int score:sVo.getScores()) {
				total += score;
				scores.add(score);
			}
			total_avg+=total;
			avg = Math.round(10*total/(double)subjectNum)/10;
			all_avg+=avg;
			total=0;
		}
		avg=0;
		for(int i=0;i<subjectNum;i++) {											// 각 과목별  평균을 저장하기 위한 for문
			for(int j=i;j<scores.size();j+=subjectNum) {						// 과목끼리 나누기위한 for문
				subjectTotalScore+=scores.get(j);								// 과목별 총점
			}
			subjectTotalScore= subjectTotalScore/(double)list.size();			// 총점/과목갯수
			avgList.add(subjectTotalScore);										// 평균 저장
			subjectTotalScore=0;
		}
		total_avg= Math.round(10*total_avg/list.size())/10.0;
		all_avg=Math.round(10*all_avg/list.size())/10.0;
		
		classScore.setClass_name(u_class);
		classScore.setClass_avg(avgList);
		classScore.setTotal_avg(total_avg);
		classScore.setAll_avg(all_avg);
		
		return classScore;
	}
}
