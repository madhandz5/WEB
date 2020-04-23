package com.kh.jspPrac.menu.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MenuOrderServlet
 */
public class MenuOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MenuOrderServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// request.setCharacterEncoding("text/html; charset=UTF-8");
		// response.setContentType("UTF-8");

		String[] menu = request.getParameterValues("menu");

		int price = 0;
		if (menu != null) {
			for (int i = 0; i < menu.length; i++) {
				switch (menu[i]) {
				case "피자":
					price += 27000;
					System.out.println(price);
					break;

				case "떡볶이":
					price += 6000;
					System.out.println(price);
					break;

				case "치킨":
					price += 20000;
					System.out.println(price);
					break;

				case "연어":
					price += 16000;
					System.out.println(price);
					break;
				}
			}
		} else {
			request.setAttribute("result", "아무것도 선택하지 않았어요");
		}

		request.setAttribute("price", price);
		request.setAttribute("menu", menu);

		RequestDispatcher view = request.getRequestDispatcher("views/menu/03_menuResult.jsp");

		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
