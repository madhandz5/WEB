package com.kh.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class H_SessionServlet
 */
// @WebServlet("/H_SessionServlet")
public class H_SessionServlet extends HttpServlet {

	// private BmLogFactory logger = BmLogFactory.getInstance();
	Logger log = Logger.getLogger(H_SessionServlet.class);

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public H_SessionServlet() {
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

		// 사용자가 보낸 URI가 session/login 으로 끝날 경우
		// login 메서드 호출

		// 사용자가 보낸 uri가 /session/logout 으로 끝날 경우
		// log out 메서드 호출

		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());

		if (command.equals("/session/logIn")) {
			logIn(request, response);
		} else if (command.equals("/session/logOut")) {
			logOut(request, response);
		}

		HttpSession session = request.getSession(false);
		session.setAttribute("id", request.getParameter("id"));

		// response.setHeader("Set-Cookie", "JSESSIONID=" + session.getId() +
		// ";Max-Age=3600;Path=/servlet01Project");
		// session.setMaxInactiveInterval(5);
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

	private void logIn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("로그인");
		// 세션이 존재하지 않을 경우에 세션을 만들지 않음
		HttpSession session = request.getSession();
		session.setAttribute("id", request.getParameter("id"));

		// response.setHeader("Set-Cookie", "JSESSIONID=" + session.getId() +
		// ";Max-Age=3600;Path=/servlet01Project");
		// session.setMaxInactiveInterval(5);
		PrintWriter pw = response.getWriter();

		if (getServletContext().getAttribute("total") != null) {

			if (session.getAttribute("id") == null) {
				int total = (int) getServletContext().getAttribute("total");
				getServletContext().setAttribute("total", ++total);
				log.info(request.getParameter("id") + "님이 로그인 하셨습니다.");
				log.info("현재 접속자는 " + getServletContext().getAttribute("total") + "명 입니다.");

			}
		} else {
			getServletContext().setAttribute("total", 1);
		}
		pw.write("<h1>" + session.getAttribute("id")
				+ "님 환영합니다. <a href='/servlet01Project/session/logOut'>로그아웃하기</a></h1>");
		// log.info(request.getParameter("id") + "님이 로그인 하셨습니다.");
		// log.info("현재 접속자는 " + getServletContext().getAttribute("total") + "명 입니다.");
		pw.write("<h3> 현재 접속자는 " + (int) getServletContext().getAttribute("total") + "명 입니다.");
		pw.write("<h3>index</h3>");
		pw.write("<a href='/servlet01Project/index.html'>index.html</a><br>");
		pw.write("<a href='/servlet01Project/1_submit.html'>1_submit.html</a><br>");
		pw.write("<a href='/servlet01Project/2_request.html'>2_request.html</a><br>");
		pw.write("<a href='/servlet01Project/3_responseTest.html'>3_responseTest.html</a><br>");
		pw.write("<a href='/servlet01Project/4_pageChange.html'>4_pageChange.html</a><br>");
		pw.write("<a href='/servlet01Project/5_cache.html'>5_cache.html</a><br>");
		pw.write("<a href='/servlet01Project/6_Cookie.html'>6_Cookie.html</a><br>");
		pw.write("<a href='/servlet01Project/7_session.html'>7_session.html</a><br>");
		pw.write("<a href='/servlet01Project/prac_food.html'>prac_food.html</a><br>");

		pw.flush();
		pw.close();
	}

	private void logOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("로그아웃");
		HttpSession session = request.getSession(false);
		// session.invalidate();

		if (session.getAttribute("id") != null) {
			int total = (int) getServletContext().getAttribute("total");
			getServletContext().setAttribute("total", --total);
			session.removeAttribute("id");
		}

		// response.sendRedirect("/servlet01Project/7_session.html");

		PrintWriter pw = response.getWriter();

		pw.write("<h3> 현재 접속자는 " + (int) getServletContext().getAttribute("total") + "명 입니다.");
		pw.write("<h3>index</h3>");
		pw.write("<a href='/servlet01Project/index.html'>index.html</a><br>");
		pw.write("<a href='/servlet01Project/1_submit.html'>1_submit.html</a><br>");
		pw.write("<a href='/servlet01Project/2_request.html'>2_request.html</a><br>");
		pw.write("<a href='/servlet01Project/3_responseTest.html'>3_responseTest.html</a><br>");
		pw.write("<a href='/servlet01Project/4_pageChange.html'>4_pageChange.html</a><br>");
		pw.write("<a href='/servlet01Project/5_cache.html'>5_cache.html</a><br>");
		pw.write("<a href='/servlet01Project/6_Cookie.html'>6_Cookie.html</a><br>");
		pw.write("<a href='/servlet01Project/7_session.html'>7_session.html</a><br>");
		pw.write("<a href='/servlet01Project/prac_food.html'>prac_food.html</a><br>");

		pw.flush();
		pw.close();

	}

}
