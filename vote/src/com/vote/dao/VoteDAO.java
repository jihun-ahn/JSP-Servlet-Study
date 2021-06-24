package com.vote.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.vote.db.DB;
import com.vote.dto.MemberDTO;
import com.vote.dto.RankDTO;
import com.vote.dto.TestDTO;
import com.vote.dto.VoteDTO;

public class VoteDAO {
	private VoteDAO() {}
	private static VoteDAO dao = new VoteDAO();
	public static VoteDAO getInstance() {
		return dao;
	}
	
	public List<MemberDTO> selectMember() {
		List<MemberDTO> list = new ArrayList<>();
		String sql = "SELECT m_no, m_name, p_name, p_school, m_jumin, m_city, p_tel1, p_tel2, p_tel3"
				+ " FROM tbl_member_202005 tm INNER JOIN tbl_party_202005 tp"
				+ " ON tm.p_code = tp.p_code";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DB.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				MemberDTO mDto = new MemberDTO();
				mDto.setM_no(rs.getString("m_no"));
				mDto.setM_name(rs.getString("m_name"));
				mDto.setP_name(rs.getString("p_name"));
				mDto.setP_school(rs.getString("p_school"));
				mDto.setM_jumin(rs.getString("m_jumin"));
				mDto.setM_city(rs.getString("m_city"));
				mDto.setP_tel(rs.getString("p_tel1").trim()+"-"+rs.getString("p_tel2")+"-"+rs.getString("p_tel3"));
				list.add(mDto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, stmt, rs);
		}		
		return list;
	}
	
	public void insertVote(VoteDTO vDto) {
		String sql = "INSERT INTO TBL_VOTE_202005 VALUES(?, ?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DB.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vDto.getV_jumin());
			psmt.setString(2, vDto.getV_name());
			psmt.setString(3, vDto.getM_no());
			psmt.setString(4, vDto.getV_time());
			psmt.setString(5, vDto.getV_area());
			psmt.setString(6, vDto.getV_confirm());
			
			psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, psmt);
		}
	}
	
	public List<VoteDTO> selectVote(){
		List<VoteDTO> list = new ArrayList<>();
		String sql = "SELECT * FROM TBL_VOTE_202005 WHERE V_AREA = '제1투표장'";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DB.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				VoteDTO vDto = new VoteDTO();
				vDto.setV_jumin(rs.getString("v_jumin"));
				vDto.setV_name(rs.getString("v_name"));
				vDto.setM_no(rs.getString("m_no"));
				vDto.setV_time(rs.getString("v_time"));
				vDto.setV_area(rs.getString("v_area"));
				vDto.setV_confirm(rs.getString("v_confirm"));
				list.add(vDto);
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, stmt, rs);
		}
		
		return list;
	}
	
	public List<RankDTO> selectRank(){
		List<RankDTO> list = new ArrayList<>();
		String sql = "SELECT tv.m_no, tm.m_name ,count(tv.m_no) cnt FROM TBL_VOTE_202005 tv INNER JOIN TBL_MEMBER_202005 tm ON tv.m_no = tm.m_no  GROUP BY tv.m_no, tm.m_name, tv.v_confirm HAVING tv.v_confirm = 'Y' ORDER BY count(tv.m_no) DESC";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DB.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		
			while(rs.next()) {
				RankDTO rDto = new RankDTO();
				rDto.setM_no(rs.getString("m_no"));
				rDto.setM_name(rs.getString("m_name"));
				rDto.setVote(rs.getString("cnt"));
				list.add(rDto);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, stmt, rs);
		}
		return list;
	}

}
