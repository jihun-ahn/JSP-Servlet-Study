package com.green.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.green.vo.MemberVo;

public class MemberDAO {	// 데이터 베이스 연동을 위한 클래스
	// 싱글톤 구성
	private MemberDAO() {};
	private static MemberDAO dao = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return dao;
	}
	
	// 데이터 베이스 연결 객체를 만드는 메서드
	public Connection getConnection() throws Exception{
		Connection conn = null;
		Context initContext = new InitialContext();
		Context envContext  = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
		conn = ds.getConnection();
		
		return conn;
	}
	
	// 아이디 정보를 통해서 회원 정보를 찾아오는 메서드
	// 아이디와 비밀번호로 저장된 아이디, 비밀번호 일치 여부를 인증처리하는 메서드
	
	public MemberVo getMember(String userid) {
		MemberVo mVo = null;
		String sql = "SELECT * FROM member WHERE userid=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, userid);
			rs = psmt.executeQuery();
			
			
			if(rs.next()) {
				mVo = new MemberVo();
				mVo.setName(rs.getString("name"));
				mVo.setUserid(rs.getString("userid"));
				mVo.setUserpwd(rs.getString("userpwd"));
				mVo.setEmail(rs.getString("email"));
				mVo.setPhone(rs.getString("phone"));
				mVo.setAdmin(rs.getInt("admin"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(psmt!=null) {psmt.close();}
				if(conn!=null) {conn.close();}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return mVo;
	}
	
	
	// 사용자 인증 처리 메서드
	public int userCheck(String userid, String userpwd) {
		int result=-1;
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		
		String sql="SELECT userpwd FROM member WHERE userid=?";
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, userid);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("userpwd")!=null 
						&& rs.getString("userpwd").equals(userpwd)) {
					result=1; // 로그인성공
				}else {
					result=0;	// 비밀번호가 null이거나 일치하지 않는경우
				}
			}else {	// 아이디를 찾을수 없는 경우
				result=-1;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(psmt!=null) {psmt.close();}
				if(conn!=null) {conn.close();}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	// 아이디 중복 체크를 위한 메서드
	public int confirmID(String userid) {
		int result=-1;
		String sql = "SELECT userid FROM member WHERE userid=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, userid);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				result=1;	// 아이디가 존재
			}else {	
				result=-1;	// 아이디가 없다
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(psmt!=null) {psmt.close();}
				if(conn!=null) {conn.close();}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	
	// 회원 가입시 사용할 쿼리문 작성할 메서드
	public int insertMember(MemberVo mVo) {
		int result = -1;
		
		String sql = "INSERT INTO member VALUES(?,?,?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, mVo.getName());
			psmt.setString(2, mVo.getUserid());
			psmt.setString(3, mVo.getUserpwd());
			psmt.setString(4, mVo.getEmail());
			psmt.setString(5, mVo.getPhone());
			psmt.setInt(6, mVo.getAdmin());
			
			result = psmt.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(psmt!=null) {psmt.close();}
				if(conn!=null) {conn.close();}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return result;
	}
	// 회원 정보 업데이트를 위한 쿼리를 작동시킬 메서드
	
	public int updateMember(MemberVo mVo) {
		int result = -1;
		
		String sql="UPDATE member SET userpwd=?, email=?, phone=?, admin=? WHERE userid=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			
			
			psmt.setString(1, mVo.getUserpwd());
			psmt.setString(2, mVo.getEmail());
			psmt.setString(3, mVo.getPhone());
			psmt.setInt(4, mVo.getAdmin());
			psmt.setString(5, mVo.getUserid());
			
			result = psmt.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(psmt!=null) {psmt.close();}
				if(conn!=null) {conn.close();}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return result;
	}

}
