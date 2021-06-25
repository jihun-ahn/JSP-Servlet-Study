package course.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import course.db.DB;
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
		String sql = "SELECT * FROM course_tbl";
		
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
	// 교과목 정보 보기
	
	// 교과목 정보 수정
	
	// 교과목 삭제
}
