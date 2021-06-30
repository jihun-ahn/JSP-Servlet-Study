package grade.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import grade.db.DBManager;
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
	public ScoreVO selectTargetScore(String name) {
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
				sVo.setKor(rs.getInt("kor"));
				sVo.setEng(rs.getInt("eng"));
				sVo.setMath(rs.getInt("math"));
				sVo.setSci(rs.getInt("sci"));
				sVo.setSoc(rs.getInt("sco"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		
		return sVo;
	}
	
	// 클래스 성적 조회
	public List<ScoreVO> selectAllScore(String u_class){
		List<ScoreVO> list = new ArrayList<>();
		String sql = "SELECT st.name, kor, eng, math, sci, soc "
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
				sVo.setName(rs.getString("name"));
				sVo.setKor(rs.getInt("kor"));
				sVo.setEng(rs.getInt("eng"));
				sVo.setMath(rs.getInt("math"));
				sVo.setSci(rs.getInt("sci"));
				sVo.setSoc(rs.getInt("soc"));
				list.add(sVo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		
		return list;
	}
}
