package com.hkitedu.lee.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hkitedu.lee.DAO.DAO_hr;
import com.hkitedu.lee.DTO.DTO_car_info;

@WebServlet("/UpdateCarServlet")
public class UpdateCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateCarServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String c_name = request.getParameter("c_name");
		String c_type = request.getParameter("c_type");
		String c_regdate = request.getParameter("c_regdate");
		int c_price = Integer.parseInt(request.getParameter("c_price"));
		int c_cc = Integer.parseInt(request.getParameter("c_cc"));
		
		DTO_car_info vo = new DTO_car_info();
		
		vo.setC_name(c_name);
		vo.setC_type(c_type);
		vo.setC_regdate(c_regdate);
		vo.setC_price(c_price);
		vo.setC_cc(c_cc);
		
		request.setAttribute("vo", vo);
		
		RequestDispatcher rd = request.getRequestDispatcher("updatecar.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String c_namet = request.getParameter("c_namet");
		String c_name = request.getParameter("c_name");
		String c_type = request.getParameter("c_type");
		String c_regdate = request.getParameter("c_regdate");
		int c_price = Integer.parseInt(request.getParameter("c_price"));
		int c_cc = Integer.parseInt(request.getParameter("c_cc"));
		
		DAO_hr.updateCar(c_namet, c_name, c_type, c_regdate, c_price, c_cc);
		
		response.sendRedirect("MallServlet");
		
		
	}

}
