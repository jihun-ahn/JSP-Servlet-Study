package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import board.dto.BoardDTO;
import board.dto.WriteDTO;
import db.DBManager;

public class BoardDAO {
	private BoardDAO() {}
	private static BoardDAO dao = new BoardDAO();
	public static BoardDAO getInstance() {
		return dao;
	}
	
	// 게시물 리스트 조회
	public List<BoardDTO> selectAllBoard(){
		String sql = "SELECT * FROM board_tbl ORDER BY idx ASC";
		List<BoardDTO> list = new ArrayList<>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				BoardDTO bDto = new BoardDTO();
				bDto.setIdx(rs.getInt("idx"));
				bDto.setWriter(rs.getString("writer"));
				bDto.setSubject(rs.getString("subject"));
				bDto.setContent(rs.getString("content"));
				bDto.setT_date(rs.getTimestamp("t_date"));
				list.add(bDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		
		return list;
	}
	
	// 게시물 등록
	public void writeBoard(WriteDTO wDto) {
		String sql = "INSERT INTO board_tbl VALUES(board_seq.nextval, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, wDto.getWriter());
			psmt.setString(2, wDto.getSubject());
			psmt.setString(3, wDto.getContent());
			psmt.setTimestamp(4, wDto.getDate());
			
			psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, psmt);
		}
	}
	
	
	// 게시물 조회
	
	// 게시물 수정
	
	// 게시물 삭제
	
	
}
