package com.hkitedu.lee.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hkitedu.lee.DAO.DAO_hr;
import com.hkitedu.lee.DTO.DTO_Join_carcom;

@WebServlet("/BuyCarServlet")
public class BuyCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BuyCarServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int c_no = Integer.parseInt(request.getParameter("C_no"));
		DTO_Join_carcom vo = DAO_hr.getjoincarcom(c_no);
		request.setAttribute("vo", vo);
		RequestDispatcher rd = request.getRequestDispatcher("buycar.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int c_price = Integer.parseInt(request.getParameter("c_price"));
		String com_name = request.getParameter("com_name");
		DAO_hr.updateCom(c_price, com_name);
		response.sendRedirect("MallServlet");
	}

}
