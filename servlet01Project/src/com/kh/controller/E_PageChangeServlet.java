package com.kh.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class E_PageChange
 */
// @WebServlet("/E_PageChange")
public class E_PageChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public E_PageChangeServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 브라우저가 이미지를 다운받게끔 헤더 설정
		response.setHeader("Content-Disposition", "attachment");

		// forward : 서블릿 안에서 요청을 재 지정 해주는것,
		// response header가 유지되기 때문에 이미지가 다운로드 된다.
		if (request.getRequestURI().contains("forward")) {
			if (request.getRequestURI().contains("image")) {
				// 절대경로로 지정할 경우 루트폴더(web)을 기준으로 경로를 잡아준다.
				// 상대경로를 사용하면 현재 요청이 온 곳으로 부터 상대경로를 잡아준다.
				// 즉 아래경로는 pagechange/resources/image/5.jpg를 의미한다.
				// getRequestDispatcher("resources/image/5.jpg)
				RequestDispatcher view = request.getRequestDispatcher("/resources/image/5.jpg");
				view.forward(request, response);
			} else {
				RequestDispatcher view = request.getRequestDispatcher("/pagechangeres");
				view.forward(request, response);
			}
		} else {
			// redirect는 브라우저에게 302 statement 코드를 응답한다.
			// 브라우저는 서버가 요청한 경로로 다시 서버에게 요청을 보낸다.
			// 새로운 request response 객체가 생성되어서 우리가 설정한 header 값이 사라지게 된다.
			if (request.getRequestURI().contains("image")) {
				response.sendRedirect("/servlet01Project/resources/image/5.jpg");
			} else {
				response.sendRedirect("/servlet01Project/pagechangeres");
			}
		}
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
