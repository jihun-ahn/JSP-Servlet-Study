package course.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import course.db.DB;
import course.dto.CourseDTO;
import course.dto.CourseVO;

public class CourseDAO {
	private CourseDAO() {}
	private static CourseDAO dao = new CourseDAO();
	public static CourseDAO getInstance() {
		return dao;
	}
	
	// 교과목 목록 보기
	public List<CourseVO> selectAllCourse(){
		List<CourseVO> list = new ArrayList<>();
		String sql = "SELECT c.id, c.name, c.credit, l.name lecturer, c.week, c.start_hour, c.end_hour "
				+ " FROM course_tbl c join lecturer_tbl l "
				+ " ON c.lecturer=l.idx";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DB.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				CourseVO cVo = new CourseVO();
				cVo.setId(rs.getString("id"));
				cVo.setName(rs.getString("name"));
				cVo.setCredit(rs.getInt("credit"));
				cVo.setLecturer(rs.getString("lecturer"));
				cVo.setWeek(rs.getInt("week"));
				cVo.setStart_hour(rs.getInt("start_hour"));
				cVo.setEnd_hour(rs.getInt("end_hour"));
				list.add(cVo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, stmt, rs);
		}
		
		
		return list;
	}
	// 교과목 등록
	public void insertCourse(CourseVO cVo) {
		String sql = "INSERT INTO course_tbl VALUES(?, ?, ?, ?, ?, ?, ?)";
												//코드 과목명 강사 학점 요일 시작 종료
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DB.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, cVo.getId());
			psmt.setString(2, cVo.getName());
			psmt.setInt(3, cVo.getCredit());
			psmt.setString(4, cVo.getLecturer());
			psmt.setInt(5, cVo.getWeek());
			psmt.setInt(6, cVo.getStart_hour());
			psmt.setInt(7, cVo.getEnd_hour());
			
			psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, psmt);
		}
	}
	
	// 교과목 정보 보기
	public CourseVO selectTargetCourse(int id) {
		String sql = "SELECT * FROM course_tbl WHERE id="+id;
		CourseVO cVo = new CourseVO();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DB.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				cVo.setId(rs.getString("id"));
				cVo.setName(rs.getString("name"));
				cVo.setCredit(rs.getInt("credit"));
				cVo.setLecturer(rs.getString("lecturer"));
				cVo.setWeek(rs.getInt("week"));
				cVo.setStart_hour(rs.getInt("start_hour"));
				cVo.setEnd_hour(rs.getInt("end_hour"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, stmt, rs);
		}
		
		return cVo;
	}
	// 교과목 정보 수정
	public void updateCourse(CourseVO cVo) {
		String sql = "UPDATE course_tbl SET name=?, credit=?, lecturer=?, week=?, start_hour=?, end_hour=? "
					+ " WHERE id="+cVo.getId();
		//코드 과목명 강사 학점 요일 시작 종료
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DB.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, cVo.getName());
			psmt.setInt(2, cVo.getCredit());
			psmt.setString(3, cVo.getLecturer());
			psmt.setInt(4, cVo.getWeek());
			psmt.setInt(5, cVo.getStart_hour());
			psmt.setInt(6, cVo.getEnd_hour());
			
			psmt.executeUpdate();
		
		} catch (Exception e) {
		e.printStackTrace();
		} finally {
			DB.close(conn, psmt);
		}
	}
	// 교과목 삭제
	public void deleteCourse(int id) {
		String sql = "DELETE course_tbl WHERE id="+id;
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = DB.getConnection();
			stmt = conn.createStatement();			
			stmt.executeUpdate(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, stmt);
		}	
	}	
}