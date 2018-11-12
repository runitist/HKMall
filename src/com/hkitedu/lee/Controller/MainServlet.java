package com.hkitedu.lee.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MainServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[MainServlet get메서드 실행]");
		
		RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
		System.out.println("main.jsp로 이동");
		rd.forward(request, response);
		
		System.out.println("[MainServlet get메서드 종료]");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[MainServlet post메서드 실행]");
		System.out.println("[MainServlet post메서드 종료]");
	}

}
