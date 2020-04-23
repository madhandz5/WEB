package com.prac.login.controller;

import java.io.IOException;

import javax.print.DocFlavor.STRING;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.metal.MetalComboBoxUI.MetalComboBoxLayoutManager;

import com.prac.login.model.serivce.PageService;
import com.prac.login.model.vo.Member;

public class PageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PageController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uri = request.getRequestURI();
		String context = request.getContextPath();
		String command = uri.substring(context.length());
		// 로그인 페이지에서 action 으로 날려준 URI 에서 내 ContextPath를 짤라내면 , 결국 Web.xml에서 매핑해준
		// URL 패턴만 남게된다. 그래서 이 패턴으로 분기를 나누어, 기능을 구현한다.
		if (command.equals("/uclass/login")) {
			memberLogin(request, response);
		} else if (command.equals("/uclass/memberjoin")) {
			memberJoin(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	Member member = null;
	PageService ps = new PageService();

	private void memberJoin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("회원가입 기능 호출 하였습니다.");
		String mId = request.getParameter("userId");
		String mPwd = request.getParameter("userPwd");
		String mGender = request.getParameter("gender");

		// System.out.println("아이디 : " + mId + "비밀번호 : " + mPwd + "성별 : " + mGender);

		member = new Member();
		member.setmId(mId);
		member.setmPwd(mPwd);
		member.setmGender(mGender);

		request.setAttribute("member", member);

		int res = ps.memberJoin(member);

		if (res == 1) {
			request.setAttribute("isSuccess", "가입성공!");
		} else {
			request.setAttribute("isSuccess", "가입실패!");
		}

		RequestDispatcher view = request.getRequestDispatcher("/views/joinResult.jsp");
		view.forward(request, response);
	}

	private void memberLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("로그인 기능 호출하였습니다.");
		String inputId = request.getParameter("userId");
		String inputPwd = request.getParameter("userPwd");
		System.out.println("입력된 아이디 : " + inputId + "입력된 비밀번호 : " + inputPwd);

		member = new Member();
		member.setmId(inputId);
		member.setmPwd(inputPwd);

		int res = ps.memberLogin(member);

		if (res > 0) {
			request.setAttribute("isLogin", "로그인 성공!");
		} else {
			request.setAttribute("isLogin", "로그인 실패!");
		}
		RequestDispatcher view = request.getRequestDispatcher("/views/loginResult.jsp");
		view.forward(request, response);
	}

}
