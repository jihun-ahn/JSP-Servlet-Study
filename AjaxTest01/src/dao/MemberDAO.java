package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import dto.MemberDTO;

public class MemberDAO {
	private MemberDAO() {}
	private static MemberDAO dao = new MemberDAO();
	public static MemberDAO getInstance() {
		return dao;
	}
	
	public List<MemberDTO> selectAllMember(){
		List<MemberDTO> list = new ArrayList<>();
		String sql = "SELECT * FROM MemberTest";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DB.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setUserId(rs.getString("userId"));
				dto.setUserName(rs.getString("userName"));
				dto.setUserPwd(rs.getString("userPwd"));
				
				list.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, stmt, rs);
		}
		return list;
	}
}
