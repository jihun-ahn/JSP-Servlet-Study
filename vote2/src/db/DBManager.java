package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBManager {
	
	public static Connection getConnection() throws Exception {
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String userId = "system";
		String userPwd = "1234";
		
		Class.forName("oracle.jdbc.OracleDriver");
		
		Connection conn = DriverManager.getConnection(url, userId, userPwd);
		
		return conn;
	}
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if(rs!=null) {rs.close();}
			if(stmt!=null) {stmt.close();}
			if(conn!=null) {conn.close();}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void close(Connection conn, Statement stmt) {
		try {
			if(stmt!=null) {stmt.close();}
			if(conn!=null) {conn.close();}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
