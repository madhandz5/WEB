package com.kh.jspPrac.member.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.jspPrac.member.model.service.MemberService;
import com.kh.jspPrac.member.model.vo.Member;

public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());

		if (command.equals("/member/join")) {
			insertMember(request, response);
		} else if (command.equals("member/idCheck")) {

		}
	}

	MemberService ms = new MemberService();

	private void insertMember(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher view = null;
		String id = request.getParameter("userId");
		String pwd = request.getParameter("userPwd");
		String tell = request.getParameter("m_tell");

		Member m = new Member();
		m.setmId(id);
		m.setmPwd(pwd);
		m.setPhone(tell);

		ms.insertMember(m);

		request.setAttribute("member", m);
		view = request.getRequestDispatcher("/views/member/joinComplete.jsp");
		view.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
