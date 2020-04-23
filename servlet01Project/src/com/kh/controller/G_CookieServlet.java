package com.kh.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 * Servlet implementation class G_Cookie
 */
// @WebServlet("/G_Cookie")
public class G_CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public G_CookieServlet() {
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

		// 쿠키의 지속시간
		// 쿠키의 지속시간을 지정하지 않으면 세션 쿠키가 된다.
		// 세션 쿠키는 세션 스코프를 지니는 쿠키를 이야기 한다.
		// 세션 스코프 : 사용자가 브라우저를 종료할 때까지 쿠키가 존재

		String search = request.getParameter("search");
		String recentSearch = "최근 검색어가 없습니다.";

		// request.getCookies() Cookie 배열을 반환
		if (request.getCookies() != null) {
			for (Cookie ck : request.getCookies()) {
				if (ck.getName().equals("recentSearch")) {
					recentSearch = ck.getValue();
				}
			}
		}

		Cookie cookie = new Cookie("recentSearch", search);
		cookie.setMaxAge(3600);
		response.addCookie(cookie);

		HttpSession session = request.getSession();
		session.getAttribute("id");

		PrintWriter pw = response.getWriter();

		if (session != null) {
			pw.write("<h1>" + session.getAttribute("id") + "님 환영합니다.<h1>");
		}

		pw.println("<h3>최근 검색어 : " + recentSearch + "</h3>");
		pw.println("<h3>현재 검색어 : " + request.getParameter("search") + "</h3>");
		pw.flush();
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
