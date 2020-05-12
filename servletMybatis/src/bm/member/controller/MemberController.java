package bm.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import bm.member.model.service.MemberService;
import bm.member.model.vo.Member;
import common.frontcontroller.Controller;
import common.frontcontroller.ModelAndView;

public class MemberController implements Controller {

	public MemberService ms = new MemberService();

	public ModelAndView join(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();

		mav.setView("member/memberJoin");

		return mav;

	}

	public ModelAndView login(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setView("member/login");
		return mav;
	}

	public ModelAndView idCheck(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();
		String res = ms.idCheck(request.getParameter("userId"));
		mav.setView("ajax");
		mav.addObject("userId", res);

		return mav;

	}

	/**
	 *1.MethodName :
	  2.ClassName :MemberController.java
	  3.Comment :
	  4.�옉�꽦�옄 : �삤李쎌쁺
	  5.�옉�꽦�씪 : 2020. 4. 17.	 
	 */
	public ModelAndView joinEmailCheck(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();
		Member m = new Member();
		m.setM_id(request.getParameter("userId"));
		m.setM_password(request.getParameter("userPwd"));
		m.setM_email(request.getParameter("m_email"));
		m.setM_tell(request.getParameter("m_tell"));

		ms.joinEmailCheck(m);
		mav.addObject("alertMsg", "�벑濡앺븯�떊 �씠硫붿씪濡� �씤利앸찓�씪�씠 諛쒖넚�릺�뿀�뒿�땲�떎.");
		mav.addObject("url", "/servletBM/index/index.do");
		mav.setView("common/result");
		return mav;

	}

	public ModelAndView joinImple(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();
		Member m = new Member();
		m.setM_id(request.getParameter("userId"));
		m.setM_password(request.getParameter("userPwd"));
		m.setM_email(request.getParameter("m_email"));
		m.setM_tell(request.getParameter("m_tell"));

		int res = ms.insertMember(m);
		if (res >= 1) {
			mav.setView("member/joinComplete");

		} else {
			mav.setView("member/memberJoin");
			mav.addObject("isSuccess", "false");
		}

		return mav;
	}

	public ModelAndView loginImple(HttpServletRequest request) {

		Member member = null;
		ModelAndView mav = new ModelAndView();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		member = ms.logInImple(id, pw);
		if (member != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginInfo", member);
			mav.setView("index/index");
		} else {
			mav.addObject("alertMsg", "�븘�씠�뵒�굹 鍮꾨�踰덊샇瑜� �솗�씤�빐二쇱꽭�슂");
			mav.addObject("url", "/servletBM/member/login.do");
			mav.setView("common/result");
		}
		return mav;
	}

	public ModelAndView logoutImple(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();

		request.getSession().invalidate();

		mav.setView("index/index");
		return mav;
	}

	public ModelAndView modifyPw(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("loginInfo");

		String id = member.getM_id();
		String newPwd = request.getParameter("newPwd");

		int res = ms.modifyPw(id, newPwd);
		
		if (res >= 1) {
			mav.addObject("alertMsg", "鍮꾨�踰덊샇媛� �젙�긽�쟻�쑝濡� �닔�젙�릺�뿀�뒿�땲�떎.");
			mav.addObject("url", "/servletBM/index/index.do");
			mav.setView("common/result");
		} else {
			mav.addObject("alertMsg", "鍮꾨�踰덊샇 �닔�젙�뿉 �떎�뙣�븯���뒿�땲�떎.");
			mav.addObject("url", "/servletBM/mypage/mypage.do");
			mav.setView("common/result");
		}

		return mav;

	}
}
