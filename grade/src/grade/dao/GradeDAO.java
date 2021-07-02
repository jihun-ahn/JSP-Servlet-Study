package grade.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import grade.db.DBManager;
import grade.dto.ScoreClassDTO;
import grade.dto.SubjectVO;
import grade.dto.ScoreVO;
import grade.dto.UserDTO;

public class GradeDAO {
	private GradeDAO() {}
	private static GradeDAO dao = new GradeDAO();
	public static GradeDAO getInstance() {
		return dao;
	}
	
	// 회원가입
	public void insertSignUp(UserDTO dto) {
		String sql = "INSERT INTO "+dto.getJob()+"_tbl VALUES(?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getPwd());
			psmt.setString(4, dto.getU_class());
			
			psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, psmt);
		}
		
	}
	// 학생 로그인
	public UserDTO selectStudentSignIn(String id) {
		String sql = "SELECT * FROM student_tbl WHERE id='"+id+"'";
		UserDTO dto = new UserDTO();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setPwd(rs.getString("pwd"));
				dto.setU_class(rs.getString("s_class"));
				dto.setJob("student");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		
		return dto;
	}
	// 선생 로그인
	public UserDTO selectTeacherSignIn(String id) {
		String sql = "SELECT * FROM teacher_tbl WHERE id='"+id+"'";
		UserDTO dto = new UserDTO();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setPwd(rs.getString("pwd"));
				dto.setU_class(rs.getString("t_class"));
				dto.setJob("teacher");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		
		return dto;
	}
	
	// 개인 성적 조회
	public ScoreVO selectTargetScore(String name, int subjectNum) {
		ScoreVO sVo = new ScoreVO();
		String sql = "SELECT * FROM score_tbl WHERE name='"+name+"'";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				List<Integer> subjectScore = new ArrayList<>();
				sVo.setName(rs.getString(1));
				for(int i=0;i<subjectNum;i++) {
					subjectScore.add(rs.getInt(i+2));
				}
				sVo.setScores(subjectScore);				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return sVo;
	}
	
	// 클래스 성적 조회
	public List<ScoreVO> selectAllScore(String u_class, int subjectNum){
		List<ScoreVO> list = new ArrayList<>();
		String sql = "SELECT * "
				+ " FROM student_tbl st join score_tbl sc "
				+ " ON st.name=sc.name "
				+ " WHERE s_class = '"+u_class+"'";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				ScoreVO sVo = new ScoreVO();
				List<Integer> scores = new ArrayList<>();
				sVo.setName(rs.getString(2));
				
				for(int i=0;i<subjectNum;i++) {
					scores.add(rs.getInt(i+6));					
				}
				sVo.setScores(scores);
				list.add(sVo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}		
	
	// 과목 갯수 조회
	public int getSubjectNumber(){
		List<String> subjectName = new ArrayList<>();
		String sql = "SELECT name FROM subject_tbl";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				subjectName.add(rs.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return subjectName.size();
	}
	
	// 전체 점수 조회
	public List<ScoreVO> selectTest(int size){
		List<ScoreVO> list = new ArrayList<>();
		
		String sql = "SELECT * FROM score_tbl";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				ScoreVO dto = new ScoreVO();
				List<Integer> subjectScore = new ArrayList<>();
				dto.setName(rs.getString("name"));
				for(int i=0;i<size;i++) {
					subjectScore.add(rs.getInt(i+2));
				}
				dto.setScores(subjectScore);
				list.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		
		return list;
	}
	
	// 과목 조회
	public List<SubjectVO> selectAllSubject(){
		List<SubjectVO> subjectList = new ArrayList<>();
		
		String sql = "SELECT * FROM subject_tbl";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				SubjectVO sVo = new SubjectVO();
				sVo.setId(rs.getString(1));
				sVo.setName(rs.getString(2));
				subjectList.add(sVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		
		return subjectList;
	}
	
	// 과목 등록(과목 테이블)
	public void insertSubject(String id, String name) {
		String sql = "INSERT INTO subject_tbl VALUES(?, ?)";
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, name);
			
			psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, psmt);
		}
	}
	// 과목 등록(성적 테이블)
	public void insertSubject(String id) {
		String sql = "ALTER TABLE score_tbl " + 
				" ADD ("+id+" number(3) default 0)";
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();			
			stmt.executeUpdate(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt);
		}
	}
	
	// 이름 조회
	public List<String> selectClassStudent(String s_class){
		List<String> list = new ArrayList<>();
		String sql = "SELECT name FROM student_tbl WHERE s_class='"+s_class+"'";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String studentName = rs.getString("name");
				list.add(studentName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}
}
