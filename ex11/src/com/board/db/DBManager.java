package com.board.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBManager {	// DB 연결과 해제를 담당할 메서드

	// DB 연결 메서드
	public static Connection getConnection(){	// DBManager.getConnection();
		
		Connection conn = null;
		
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup("java:/comp/env");
			
			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
			
			conn = ds.getConnection();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	// DB를 해제하기 위한 메서드
	// 1. RS 해제 포함 select
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if(rs!=null) {rs.close();}
			if(stmt!=null) {stmt.close();}
			if(conn!=null) {conn.close();}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	// 2. RS 해제 미포함 insert, delete, update
	public static void close(Connection conn, Statement stmt) {
		try {
			if(stmt!=null) {stmt.close();}
			if(conn!=null) {conn.close();}	
		}catch (Exception e) {
			e.printStackTrace();
		}
	}


}
