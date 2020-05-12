package bm.mypage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import bm.member.model.vo.Member;
import common.frontcontroller.Controller;
import common.frontcontroller.ModelAndView;

public class MyPageController implements Controller {

	public ModelAndView myPage(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();

		Member member = null;
		HttpSession session = request.getSession();
		member = (Member) session.getAttribute("loginInfo");

		mav.addObject("loginInfo", member);
		mav.setView("mypage/mypage");

		return mav;
	}


}
