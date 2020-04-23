package com.kh.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class C_RequestServlet
 */
// @WebServlet("/C_RequestServlet")
public class C_RequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public C_RequestServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// HttpServletRequest : 클라이언트 (브라우저) 가 웹서버에 요청할 때 함께 전달되는 정보를 저장하고 있는 객체
		// ex) 브라우저 정보, 클라이언트 시스템 정보, 쿠키, 세션, 사용자가 전송한 데이터 등등...

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		// 클라이언트가 사용한 URI 저장
		String uri = request.getRequestURI();
		System.out.println(uri);

		// 컨텍스트패스 저장
		String conPath = request.getContextPath();
		System.out.println(conPath);

		// 컨텍스트 패스 뒷 부분만 잘라냄
		String command = uri.substring(conPath.length());

		if (command.equals("/request/urlencoded")) {
			responseUrlEncoded(request, response);
		} else if (command.equals("/request/multi")) {
			responseMulti(request, response);
		}
		// response.getWriter().println("<h5>이름 : " + request.getParameter("name") +
		// "</h5>");

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

	private void responseUrlEncoded(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();

		// 원래 application/x-www-form-urlencoded 컨텐츠 타입이
		// 데이터를 어떤 형태로 보내는지 확인해보기.

		// int data = 0;
		// String origin = "";
		// while ((data = request.getInputStream().read()) != -1) {
		// origin += (char) data;
		// }
		// pw.println("<h1>origin : " + origin + "</h1>");

		// pw.println("<h1>Request 객체입니다.</h1>");
		// pw.println("<h5>요청 컨텐츠 타입 : " + request.getContentType() + "</h5>");
		// pw.println("<h5>클라이언트 IP : " + request.getRemoteAddr() + "</h5>");
		// pw.println("<h5>HTTP Method : " + request.getMethod() + "</h5>");
		// pw.println("<h5>서버 이름 : " + request.getServerName() + "</h5>");
		// pw.println("<h5>요청 URI 경로 : " + request.getRequestURI() + "</h5>");
		// pw.println("<h5>ContextPath : " + request.getContextPath() + "</h5>");

		// request.getParameter() 사용해서 name이랑 age 찍어보기
		pw.println("<h5>getParameter 이름 : " + request.getParameter("name") + "</h5>");
		pw.println("<h5>getParameter 나이 : " + request.getParameter("age") + "</h5>");

		// request.getParameterMap() 메서드 써보기
		String[] name = request.getParameterMap().get("name");
		String[] age = request.getParameterMap().get("age");

		// pw.println("<h5>getParameterMap 이름: " + Arrays.toString(name) + "<h5>");
		// pw.println("<h5>getParameterMap 나이: " + Arrays.toString(age) + "<h5>");

		Map resMap = request.getParameterMap();
		for (String s : request.getParameterMap().keySet()) {
			String[] sa = request.getParameterMap().get(s);
			for (String res : sa) {
				pw.println("<h5>getParameterMap " + s + " : " + res + "<h5>");
			}
		}

	}

	private void responseMulti(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		InputStream is = request.getInputStream();
		OutputStream os = new FileOutputStream(new File(getServletContext().getRealPath("/resources") + "/text.txt"));

		int check = 0;
		while ((check = is.read()) != -1) {
			os.write(check);
		}
		os.close();
		is.close();

		PrintWriter pw = response.getWriter();

		pw.println("<h1>Request 객체입니다.</h1>");
		pw.println("<h5>요청 컨텐츠 타입 : " + request.getContentType() + "</h5>");
		pw.println("<h5>클라이언트 IP : " + request.getRemoteAddr() + "</h5>");
		pw.println("<h5>HTTP Method : " + request.getMethod() + "</h5>");
		pw.println("<h5>서버 이름  : " + request.getServerName() + "</h5>");
		pw.println("<h5>요청 URI 경로 : " + request.getRequestURI() + "</h5>");
		pw.println("<h5>ContextPath : " + request.getContextPath() + "</h5>");

	}

}
