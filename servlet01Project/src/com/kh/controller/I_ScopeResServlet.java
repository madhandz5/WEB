package com.kh.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class I_ScopeResServlet
 */
// @WebServlet("/I_ScopeResServlet")
public class I_ScopeResServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public I_ScopeResServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		int reqSum = (request.getAttribute("requestSum") == null) ? 0 : (int) (request.getAttribute("requestSum"));

		HttpSession session = request.getSession();
		int sessionSum = (session.getAttribute("sessionSum") == null) ? 0 : (int) (session.getAttribute("sessionSum"));

		ServletContext context = getServletContext();
		int contextSum = (context.getAttribute("contextSum") == null) ? 0 : (int) (context.getAttribute("contextSum"));

		PrintWriter pw = response.getWriter();
		pw.println("<h2>Request 영역</h2>");
		pw.println("<h4>각 페이지 간의 정보가 전달되는 범위를 말한다.<br> 이동하는 페이지마다 생성되고 사라진다.</h4>");
		pw.println("계산결과 : " + reqSum);
		pw.println("<br><hr>");

		pw.println("<h2>Session 영역</h2>");
		pw.println("<h4>웹브라우저로 연결하는 동안 객체를 생성하여 유지하며<br> 연결이 종료되면 사라진다.</h4>");
		pw.println("계산결과 : " + sessionSum);
		pw.println("<br><hr>");

		pw.println("<h2>context 영역</h2>");
		pw.println("<h4>서버가 실행되어 있는 동안에 객체를 유지하는 범위<br> 버서가 실행되어 있는 동안 계속 정보를 유지한다.</h4>");
		pw.println("계산결과 : " + contextSum);
		pw.println("<br><hr>");

		pw.flush();
		pw.close();

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
