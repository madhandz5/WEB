package bm.book.controller;

import javax.servlet.http.HttpServletRequest;

import bm.book.model.service.BookService;
import common.frontcontroller.Controller;
import common.frontcontroller.ModelAndView;

public class BookController implements Controller {

	private BookService bs = new BookService();

	// 여기까지 정상 실행됨 버그 없음.

	public ModelAndView bookSearch(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		String keyWord = request.getParameter("searchBook");

		mav.addObject("searchList", bs.bookSearch(keyWord));
		mav.setView("book/booksearch");

		return mav;
	}

}
