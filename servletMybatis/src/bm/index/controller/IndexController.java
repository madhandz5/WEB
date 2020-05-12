package bm.index.controller;

import javax.servlet.http.HttpServletRequest;

import common.frontcontroller.Controller;
import common.frontcontroller.ModelAndView;

public class IndexController implements Controller {

	public ModelAndView index(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();
		mav.setView("index/index");
		return mav;
	}
}
