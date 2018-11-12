package com.hkitedu.lee.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hkitedu.lee.DAO.DAO_hr;
import com.hkitedu.lee.DTO.DTO_company_info;

@WebServlet("/carJoinServlet")
public class carJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public carJoinServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[carJoinServlet get메서드 실행]");
		int maxc_no = 0;
		List<DTO_company_info> ldci = null;
		try {
			maxc_no = DAO_hr.getMaxc_no();
			ldci = DAO_hr.getCominfoList();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("ldci", ldci);
		request.setAttribute("maxc_no", maxc_no);
		RequestDispatcher rd = request.getRequestDispatcher("carJoin.jsp");
		System.out.println("carJoin.jsp로 이동");
		rd.forward(request, response);
		System.out.println("[carJoinServlet get메서드 종료]");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[carJoinServlet post메서드 실행]");
		request.setCharacterEncoding("UTF-8");
		int c_no = Integer.parseInt(request.getParameter("c_no"));
		String com_name = request.getParameter("com_name");
		String c_name = request.getParameter("c_name");
		String c_type = request.getParameter("c_type");
		String c_regdate = request.getParameter("c_regdate");
		int c_price = Integer.parseInt(request.getParameter("c_price"));
		int c_cc = Integer.parseInt(request.getParameter("c_cc"));
		
		DAO_hr.inputCar(c_no, com_name, c_name, c_type, c_regdate, c_price, c_cc);
		
		
		response.sendRedirect("MallServlet");
		System.out.println("[carJoinServlet post메서드 종료]");
	}

}
