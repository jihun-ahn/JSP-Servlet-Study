package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vote.dto.MemberVO;

import db.DBManager;

public class VoteDAO {
	private VoteDAO() {}
	private static VoteDAO dao = new VoteDAO();
	public static VoteDAO getInstance() {
		return dao;
	}
	
	// 후보 조회
	public List<MemberVO> selectAllMember(){
		
		List<MemberVO> list = new ArrayList<>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT m_no, m_name, p_name, p_school, m_jumin, m_city, p_tel1, p_tel2, p_tel3"
				+ " FROM tbl_member_202005 tm INNER JOIN tbl_party_202005 tp"
				+ " ON tm.p_code = tp.p_code";
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				MemberVO vo = new MemberVO();
				
				vo.setM_no(rs.getString("m_no"));
				vo.setM_name(rs.getString("m_name"));
				vo.setP_name(rs.getString("p_name"));
				vo.setP_school(rs.getString("p_school"));
				vo.setM_jumin(rs.getString("m_jumin"));
				vo.setM_city(rs.getString("m_city"));
				vo.setP_tel1(rs.getString("p_tel1"));
				vo.setP_tel2(rs.getString("p_tel2"));
				vo.setP_tel3(rs.getString("p_tel3"));
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		
		return list;
	}
	
}
