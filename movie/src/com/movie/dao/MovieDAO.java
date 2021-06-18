package com.movie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.movie.db.DB;
import com.movie.vo.MovieVO;

public class MovieDAO {
	
	// 싱글톤 패턴
	private MovieDAO() {}
	private static MovieDAO dao = new MovieDAO();
	public static MovieDAO getInstance() {
		return dao;
	}
	
	public List<MovieVO> selectAllMovieList(){
		List<MovieVO> movieList = new ArrayList<>();
		
		String sql = "SELECT * FROM movie";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {			
			conn = DB.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				MovieVO mVo = new MovieVO();
				mVo.setCode(rs.getInt("code"));
				mVo.setTitle(rs.getString("title"));
				mVo.setDirector(rs.getString("director"));
				mVo.setActor(rs.getString("actor"));
				mVo.setCost(rs.getInt("cost"));
				mVo.setImageurl(rs.getString("imageurl"));
				mVo.setScore(rs.getDouble("score"));
				
				movieList.add(mVo);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DB.close(conn, stmt, rs);
		}
		return movieList;
	}
	
	// 영화 등록
	
	public void insertMovie(MovieVO mVo) {
		
		String sql = "INSERT INTO movie"
				+ " VALUES(movie_seq.nextval, ?, ?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			
			conn = DB.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, mVo.getTitle());
			psmt.setString(2, mVo.getDirector());
			psmt.setString(3, mVo.getActor());
			psmt.setInt(4, mVo.getCost());
			psmt.setString(5, mVo.getImageurl());
			psmt.setDouble(6, mVo.getScore());
			
			psmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DB.close(conn, psmt);
		}
		
	}
	
	// 영화 수정
	
	
}
