package com.kh.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycleServlet
 */
// @WebServlet("/LifeCycleServlet")
public class A_LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private int initCount = 1;
	private int doGetCount = 1;
	private int destroyCount = 1;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public A_LifeCycleServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("doGet메서드는 Get방식으로 요청이 올 때마다 호출 됨" + doGetCount);
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

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init메서드는 첫 요청시 한번만 호출됨 : " + initCount);
	}

	public void destroy() {
		System.out.println("destroy 메서드는 톰캣 종료시 호출 됨" + destroyCount);
	}

}
