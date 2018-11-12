package com.hkitedu.lee.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hkitedu.lee.DTO.DTO_Join_carcom;
import com.hkitedu.lee.DTO.DTO_RankCom;
import com.hkitedu.lee.DTO.DTO_car_info;
import com.hkitedu.lee.DTO.DTO_company_info;

public class DAO_hr {

	public static List<DTO_car_info> getCarList()
			throws ClassNotFoundException, SQLException {
		System.out.println("[getCarList 메서드 실행]");
		List<DTO_car_info> carl = new ArrayList<DTO_car_info>();
		Connection con = DBConnector.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "select c_no, com_no, c_name, c_type, to_char(c_regdate, 'yyyy-mm-dd') c_regdate, c_price, c_cc from car_info order by c_no desc";

		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				DTO_car_info vo = new DTO_car_info();
				vo.setC_no(rs.getInt("c_no"));
				vo.setCom_no(rs.getInt("com_no"));
				vo.setC_name(rs.getString("c_name"));
				vo.setC_type(rs.getString("c_type"));
				vo.setC_regdate(rs.getString("c_regdate"));
				vo.setC_price(rs.getInt("c_price"));
				vo.setC_cc(rs.getInt("c_cc"));
				carl.add(vo);
			}
			System.out.println("car정보 리스트화 성공");
		} catch (Exception e) {
			System.out.println("car정보 리스트화 실패");
			e.printStackTrace();
		} finally {
			DBConnector.closeConnection(rs, ps, con);
		}

		System.out.println("[getCarList 메서드 종료]");
		return carl;
	}

	public static int getMaxc_no() throws ClassNotFoundException, SQLException {
		int c_no = 0;
		Connection con = DBConnector.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select max(c_no) from car_info";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				c_no = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.closeConnection(rs, ps, con);
		}
		return c_no;
	}

	public static List<DTO_company_info> getCominfoList()
			throws ClassNotFoundException, SQLException {
		List<DTO_company_info> ldc = new ArrayList<DTO_company_info>();
		Connection con = DBConnector.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "select com_no, com_name, com_addr, com_amount, com_total from company_info order by com_no desc";

		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				DTO_company_info dci = new DTO_company_info();
				dci.setCom_no(rs.getInt(1));
				dci.setCom_name(rs.getString(2));
				dci.setCom_addr(rs.getString(3));
				dci.setCom_amount(rs.getInt(4));
				dci.setCom_total(rs.getInt(5));

				ldc.add(dci);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.closeConnection(rs, ps, con);
		}

		return ldc;
	}

	public static void inputCar(int c_no, String com_name, String c_name,
			String c_type, String c_regdate, int c_price, int c_cc) {
		Connection con = null;
		try {
			con = DBConnector.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement ps = null;

		String sql = "insert into car_info(c_no, com_no, c_name, c_type, c_regdate, c_price, c_cc) values (?,(select com_no from company_info where com_name = ?),?,?,?,?,?)";

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, c_no);
			ps.setString(2, com_name);
			ps.setString(3, c_name);
			ps.setString(4, c_type);
			ps.setString(5, c_regdate);
			ps.setInt(6, c_price);
			ps.setInt(7, c_cc);
			ps.execute();
			System.out.println("차량등록 완료");
		} catch (Exception e) {
			System.out.println("차량등록 실패");
			e.printStackTrace();
		} finally {
			DBConnector.closeConnection(null, ps, con);
		}

	}

	public static int getmaxcom_no() {
		Connection con = null;
		int max = 0;
		try {
			con = DBConnector.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "select max(com_no) from company_info";

		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				max = rs.getInt(1);
			}
		} catch (Exception e) {

		} finally {
			DBConnector.closeConnection(rs, ps, con);
		}
		return max;
	}

	public static void inputCom(int com_no, String com_name, String com_addr) {
		Connection con = null;
		try {
			con = DBConnector.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement ps = null;

		String sql = "insert into company_info (com_no, com_name, com_addr) values (?,?,?)";

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, com_no);
			ps.setString(2, com_name);
			ps.setString(3, com_addr);
			ps.execute();
		} catch (Exception e) {

		} finally {
			DBConnector.closeConnection(null, ps, con);
		}

	}

	public static DTO_Join_carcom getjoincarcom(int c_no) {
		DTO_Join_carcom vo = new DTO_Join_carcom();
		Connection con = null;
		try {
			con = DBConnector.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "select com.com_name com_name, c.c_name c_name, c.c_type c_type, to_char(c.c_regdate, 'yyyy-mm-dd') c_regdate, c.c_price c_price, c.c_cc c_cc from car_info c join company_info com on c.com_no = com.com_no where c.c_no = ?";

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, c_no);
			rs = ps.executeQuery();

			while (rs.next()) {
				String com_name = rs.getString("com_name");
				String c_name = rs.getString("c_name");
				String c_type = rs.getString("c_type");
				String c_regdate = rs.getString("c_regdate");
				int c_price = rs.getInt("c_price");
				int c_cc = rs.getInt("c_cc");
				vo.setC_name(c_name);
				vo.setCom_name(com_name);
				vo.setC_cc(c_cc);
				vo.setC_regdate(c_regdate);
				vo.setC_type(c_type);
				vo.setC_price(c_price);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.closeConnection(rs, ps, con);
		}

		return vo;
	}

	public static List<DTO_RankCom> getcomrankamount() {
		List<DTO_RankCom> vol = new ArrayList<DTO_RankCom>();
		Connection con = null;
		try {
			con = DBConnector.getConnection();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select com_name, com_amount, com_total from company_info order by com_amount desc";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				DTO_RankCom vo = new DTO_RankCom();
				vo.setCom_name(rs.getString("com_name"));
				vo.setCom_amount(rs.getInt("com_amount"));
				vol.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.closeConnection(rs, ps, con);
		}

		return vol;
	}

	public static List<DTO_RankCom> getcomranktotal() {
		List<DTO_RankCom> vol = new ArrayList<DTO_RankCom>();
		Connection con = null;
		try {
			con = DBConnector.getConnection();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select com_name, com_total from company_info order by com_total desc";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				DTO_RankCom vo = new DTO_RankCom();
				vo.setCom_name(rs.getString("com_name"));
				vo.setCom_total(rs.getInt("com_total"));
				vol.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.closeConnection(rs, ps, con);
		}

		return vol;
	}
	public static void updateCom(int c_price, String com_name){
		Connection con = null;
		try {
			con = DBConnector.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement ps = null;
		
		String sql = "update company_info set "
				+ " com_amount = "
				+ "(select com_amount from company_info where com_name = ?)+1, "
				+ "com_total="
				+ "(select com_total from company_info where com_name = ?)+? "
				+ "where com_name=?";
		
		try{
			ps = con.prepareStatement(sql);
			ps.setString(1, com_name);
			ps.setString(2, com_name);
			ps.setInt(3, c_price);
			ps.setString(4, com_name);
			ps.execute();
			
		}catch(Exception e){
			
		}finally{
			DBConnector.closeConnection(null, ps, con);
		}
	}

	public static void updateCar(String c_namet, String c_name, String c_type,
			String c_regdate, int c_price, int c_cc) {
		Connection con = null;
		try {
			con = DBConnector.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement ps = null;
		String sql = "update car_info set "
				+ "c_name = ?, "
				+ "c_type = ?, "
				+ "c_regdate = ?, "
				+ "c_price = ?, "
				+ "c_cc = ? "
				+ "where "
				+ "c_name = ?";
		
		try{
			ps = con.prepareStatement(sql);
			ps.setString(1, c_name);
			ps.setString(2, c_type);
			ps.setString(3, c_regdate);
			ps.setInt(4, c_price);
			ps.setInt(5, c_cc);
			ps.setString(6, c_namet);
			ps.execute();
		}catch(Exception e){
			
		}finally{
			DBConnector.closeConnection(null, ps, con);
		}
		
	}
}
