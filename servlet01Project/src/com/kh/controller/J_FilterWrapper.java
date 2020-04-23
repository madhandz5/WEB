package com.kh.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.filter.DataWrapper;

/**
 * Servlet implementation class J_FilterWrapper
 */
// @WebServlet("/J_FilterWrapper")
public class J_FilterWrapper extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public J_FilterWrapper() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getParameter("id"));

		// DataWrapper 에서 오버라이딩 한 getRequestDispatcher() 메서드는 매개변수로 받은 파일명을
		// WEB-INF/Image/파일명 으로 재지정 해준다.

		RequestDispatcher rd = request.getRequestDispatcher("비행운");
		rd.forward(request, response);

		// 방금 만든 getCommandMap() 메서드 호출해서 Map<String,Object> commandMap 에 넣기.
		Map<String, Object> commandMap = null;
		commandMap = (Map<String, Object>) new DataWrapper(request).getCommandMap();

		System.out.println(commandMap);
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
