package com.hrd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hrd.vo.MemberVO;
import com.hrd.vo.RevenueVO;

import DBPKG.DB;

public class MemberDAO {
	private MemberDAO() {}
	private static MemberDAO dao = new MemberDAO();
	public static MemberDAO getInstance() {
		return dao;
	}
	public int selectLastNum() {
		String sql = "SELECT LAST_NUMBER"
				+ " FROM USER_SEQUENCES"
				+ " WHERE SEQUENCE_NAME = UPPER('member_tbl_seq')";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int num = -1;
		try {
			conn = DB.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				num = rs.getInt(1);
			}

		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DB.close(conn, stmt, rs);
		}
		
		return num;
	}
	
	public List<MemberVO> selectAllMember() {
		List<MemberVO> list = new ArrayList<>();
		String sql = "SELECT * FROM member_tbl_02";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DB.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				MemberVO mVo = new MemberVO();
				mVo.setCustno(rs.getInt("custno"));
				mVo.setCustname(rs.getString("custname"));
				mVo.setPhone(rs.getString("phone"));
				mVo.setAddress(rs.getString("address"));
				mVo.setJoindate(rs.getTimestamp("joindate"));
				mVo.setGrade(rs.getString("grade"));
				mVo.setCity(rs.getString("city"));
				
				list.add(mVo);
			}

		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DB.close(conn, stmt, rs);
		}
		
		return list;
	}
	
	public void insertMember(MemberVO mVo) {
		String sql = "INSERT INTO member_tbl_02 VALUES(member_tbl_seq.nextval, ?, ?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DB.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, mVo.getCustname());
			psmt.setString(2, mVo.getPhone());
			psmt.setString(3, mVo.getAddress());
			psmt.setTimestamp(4, mVo.getJoindate());
			psmt.setString(5, mVo.getGrade());
			psmt.setString(6, mVo.getCity());
			
			psmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DB.close(conn, psmt);
		}
	}
	
	public List<RevenueVO> selectAllRevenue() {
		List<RevenueVO> list = new ArrayList<>();
		String sql = "SELECT mb.custno, mb.custname, mb.grade, SUM(mn.price) total" + 
					 " FROM member_tbl_02 mb INNER JOIN money_tbl_02 mn" + 
					 " ON mb.custno = mn.custno" + 
					 " GROUP BY mb.custno, mb.custname, mb.grade" + 
					 " ORDER BY total DESC";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DB.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				RevenueVO rVo = new RevenueVO();
				rVo.setCustno(rs.getInt("custno"));
				rVo.setCustname(rs.getString("custname"));
				rVo.setGrade(rs.getString("grade"));
				rVo.setPrice(rs.getInt("total"));
				list.add(rVo);
			}

		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DB.close(conn, stmt, rs);
		}
		
		return list;
	}
	
	public MemberVO selectTargetMember(int custno) {
		String sql = "SELECT * FROM member_tbl_02 WHERE custno="+custno;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		MemberVO mVo = new MemberVO();
		try {
			conn = DB.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				mVo.setCustno(rs.getInt("custno"));
				mVo.setCustname(rs.getString("custname"));
				mVo.setPhone(rs.getString("phone"));
				mVo.setAddress(rs.getString("address"));
				mVo.setJoindate(rs.getTimestamp("joindate"));
				mVo.setGrade(rs.getString("grade"));
				mVo.setCity(rs.getString("city"));
			}

		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DB.close(conn, stmt, rs);
		}
		
		return mVo;
		
	}
	
	public void updateMember(MemberVO mVo) {
		String sql = "UPDATE member_tbl_02" + 
				" SET custname = ?, phone = ?, address = ?, joindate = ?, grade = ?, city = ?" + 
				" WHERE custno = ?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DB.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, mVo.getCustname());
			psmt.setString(2, mVo.getPhone());
			psmt.setString(3, mVo.getAddress());
			psmt.setTimestamp(4, mVo.getJoindate());
			psmt.setString(5, mVo.getGrade());
			psmt.setString(6, mVo.getCity());
			psmt.setInt(7, mVo.getCustno());
			
			psmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DB.close(conn, psmt);
		}
	}
}
