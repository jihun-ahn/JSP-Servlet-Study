package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import board.dto.BoardDTO;
import board.dto.CommentDTO;
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
	public BoardDTO selectTargetBoard(int idx) {
		BoardDTO bDto = new BoardDTO();
		String sql = "SELECT * FROM board_tbl WHERE idx="+idx;
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				bDto.setIdx(rs.getInt("idx"));
				bDto.setWriter(rs.getString("writer"));
				bDto.setSubject(rs.getString("subject"));
				bDto.setContent(rs.getString("content"));
				bDto.setT_date(rs.getTimestamp("t_date"));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		
		return bDto;
	}
	
	// 댓글 조회
	public List<CommentDTO> selectComment(int boardidx) {
		List<CommentDTO> list = new ArrayList<>();
		
		String sql = "SELECT * FROM comment_tbl "
				+ " WHERE bidx="+boardidx
				+ " ORDER BY idx";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				CommentDTO comment = new CommentDTO();
				comment.setIdx(rs.getInt("idx"));
				comment.setBidx(rs.getInt("bidx"));
				comment.setWriter(rs.getString("writer"));
				comment.setContent(rs.getString("content"));;
				comment.setT_date(rs.getTimestamp("t_date"));
				list.add(comment);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		
		return list;
	}
	// 댓글 작성
	public void writeComment(CommentDTO cDto) {
		String sql = "INSERT INTO comment_tbl "
				+ " VALUES(comment_seq.nextval, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, cDto.getBidx());
			psmt.setString(2, cDto.getWriter());
			psmt.setString(3, cDto.getContent());
			psmt.setTimestamp(4, cDto.getT_date());
			
			psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, psmt);
		}
		
	}
	// 댓글 삭제
	public void deleteComment(int idx) {
		String sql = "DELETE comment_tbl WHERE idx="+idx;
		
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
	// 게시물 수정
	public BoardDTO selectEditBoard(int idx) {
		BoardDTO bDto = new BoardDTO();
		String sql = "SELECT * FROM board_tbl WHERE idx="+idx;
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				bDto.setIdx(rs.getInt("idx"));
				bDto.setWriter(rs.getString("writer"));
				bDto.setSubject(rs.getString("subject"));
				bDto.setContent(rs.getString("content"));
				bDto.setT_date(rs.getTimestamp("t_date"));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		
		return bDto;
	}

	public void editBoard(WriteDTO wDto, int idx) {
		String sql = "UPDATE board_tbl"
				+ " SET writer=?, subject=?, content=?, t_date=?"
				+ " WHERE idx="+idx;
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
	// 게시물 삭제
	public void deleteBoard(int idx) {
		deleteAllComment(idx);
		String sql = "DELETE board_tbl WHERE idx="+idx;
		
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

	private void deleteAllComment(int bidx) {
		String sql = "DELETE comment_tbl WHERE bidx="+bidx;
		
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
	
	
}
