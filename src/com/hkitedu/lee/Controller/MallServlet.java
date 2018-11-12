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
import com.hkitedu.lee.DTO.DTO_car_info;

@WebServlet("/MallServlet")
public class MallServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MallServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[MallServlet get메서드 실행]");
		List<DTO_car_info> carList = null;
		try {
			carList = DAO_hr.getCarList();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("carList", carList);
		
		RequestDispatcher rd = request.getRequestDispatcher("mall.jsp");
		System.out.println("mall.jsp로 이동");
		rd.forward(request, response);
		
		System.out.println("[MallServlet get메서드 종료]");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[MallServlet post메서드 실행]");
		System.out.println("[MallServlet post메서드 종료]");
	}

}
