package com.kh.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class D_ResponseServlet
 */
// @WebServlet("/D_ResponseServlet")
public class D_ResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public D_ResponseServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		// Content-Type : MIME type 지정
		// MIME TYPE : 서버가 응답할 데이터의 유형을 나타내주기 위해 사용
		// text : 문자
		// ex)text/html , text/css
		// image : 이미지
		// ex)image/gif , image/png
		// application : 바이트
		// multipart : 복합, 브라우저가 어떻게 처리해야할지 몰라서 파일을 다운받음
		// content-disposition : inline으로 지정해도 multipart일 경우 파일을 다운받음

		// response.setHeader("Content-Type", "multipart/byteranges");

		// response.setHeader("Content-Disposition", "attachment; filename=uclass.txt");
		// Content-Disposition :
		// 브라우저에게 컨텐츠가 inline되어야 하는 컨텐츠인지 아니면 파일로 받아야 하는 컨텐츠인지 알려준다.
		// attatchment : 파일형태 , inline : 브라우저에 노출
		response.setHeader("Content-Disposition", "inline");

		PrintWriter pw = response.getWriter();
		pw.println("<h3>HttpServletResponse: 클라이언트에게 응답을 보내기 위한 기능들을 가지고 있는 객체</h3>");
		pw.println("<h3>setContentType() : 응답으로 작성하는 페이지의 MIME타입을 지정</h3>");
		pw.println("<h3>setCharacterEncoding(String) : 응답할 데이터의 인코딩 지정</h3>");
		pw.println("<h3>getwriter() : printWriter</h3>");
		pw.println("<h3>getOutputStream() : OutputStream</h3>");
		pw.println("<h3>sendRedirect(String) : 브라우저에게 매개변수로 보낸 주소로 다시 요청할 것을 요청</h3>");

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
