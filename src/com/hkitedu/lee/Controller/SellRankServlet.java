package com.hkitedu.lee.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hkitedu.lee.DAO.DAO_hr;
import com.hkitedu.lee.DTO.DTO_RankCom;

@WebServlet("/SellRankServlet")
public class SellRankServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SellRankServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("sellrank.jsp");
		List<DTO_RankCom> al = DAO_hr.getcomrankamount();
		List<DTO_RankCom> tl = DAO_hr.getcomranktotal();
		
		request.setAttribute("al", al);
		request.setAttribute("tl", tl);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
