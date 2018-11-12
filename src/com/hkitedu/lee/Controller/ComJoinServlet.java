package com.hkitedu.lee.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hkitedu.lee.DAO.DAO_hr;

@WebServlet("/ComJoinServlet")
public class ComJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ComJoinServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("comjoin.jsp");
		int maxcom_no = DAO_hr.getmaxcom_no();
		request.setAttribute("maxcom_no", maxcom_no);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int com_no = Integer.parseInt(request.getParameter("com_no"));
		String com_name=request.getParameter("com_name");
		String com_addr=request.getParameter("com_addr");
		
		DAO_hr.inputCom(com_no, com_name, com_addr);
		
		response.sendRedirect("carJoinServlet");
	}

}
