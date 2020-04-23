package com.el.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.el.model.vo.Score;

public class ELController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ELController() {
		super();
	}

	List<Score> sList = new ArrayList<>();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getGrade(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	Score score = new Score();

	private void getGrade(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		int math = Integer.parseInt(request.getParameter("math"));
		int kor = Integer.parseInt(request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng"));

		score = new Score(name, kor, eng, math);
		boolean flg = true;
		for (Score s : sList) {
			if (s.equals(score)) {
				flg = false;
			}
		}
		if (flg) {
			sList.add(score);
		}
		request.setAttribute("score", sList);

		RequestDispatcher view = request.getRequestDispatcher("/EL_JSTL/jstlPage.jsp");
		view.forward(request, response);

	}
}
