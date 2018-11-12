package com.hkitedu.lee.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnector {

	public static Connection getConnection() throws ClassNotFoundException,
			SQLException {
		System.out.println("[getConnection 메서드 실행]");
		Class.forName("oracle.jdbc.OracleDriver");
		System.out.println("DB드라이버 연결 성공");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@//localhost:1521/xe", "hr", "hkitedu");
		System.out.println("DB계정 연결 성공");
		System.out.println("[getConnection 메서드 종료]");
		return con;
	}

	public static void closeConnection(ResultSet rs, PreparedStatement ps,
			Connection con) {
		System.out.println("[closeConnection 메서드 실행]");
		try {
			if (rs != null) {
				rs.close();
				System.out.println("ResultSet 닫기 성공");
			}
		} catch (Exception e) {
			System.out.println("ResultSet 닫기 실패");
			e.printStackTrace();
		}
		try {
			if (ps != null) {
				ps.close();
				System.out.println("PreparedStatement 닫기 성공");
			}
		} catch (Exception e) {
			System.out.println("PreparedStatement 닫기 실패");
			e.printStackTrace();
		}
		try {
			if (con != null) {
				con.close();
				System.out.println("Connection 닫기 성공");
			}
		} catch (Exception e) {
			System.out.println("Connection 닫기 실패");
			e.printStackTrace();
		}
		System.out.println("[closeConnection 메서드 종료]");
	}

}
