package bm.book.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import bm.book.model.service.BookService;
import bm.book.model.vo.Book;
import common.exception.BMException;
import common.frontcontroller.Controller;
import common.frontcontroller.ModelAndView;
import net.bytebuddy.dynamic.scaffold.MethodRegistry.Handler.ForAbstractMethod;

/**
 * @PackageName: bm.book.controller
 * @FileName : BookController.java
 * @Date : 2020. 4. 12.
 * @���α׷� ���� : ����ó��Ŭ����
 * @author 
 */
public class BookController implements Controller {

	BookService bs = new BookService();

	/**
	 * 1. MethodName : selectBookList
	 * 2. ClassName  : BookController.java
	 * 3. Comment    : ������Ϲ�ȯ
	 * 4. �ۼ���       : �ϸ�
	 * 5. �ۼ���       : 2020. 4. 12.
	 * @throws BMException 
	**/
	public ModelAndView selectBookList(HttpServletRequest request) throws Exception {

		ModelAndView mav = new ModelAndView();
		String title = request.getParameter("b_title");
		List<Book> res = bs.selectBookList(title);
		mav.addObject("booklist", res);
		mav.setView("book/booksearch");
		return mav;

	}

	/**
	 * 1. MethodName : selectBook
	 * 2. ClassName  : BookController.java
	 * 3. Comment    : ������
	 * 4. �ۼ���       : �ϸ�
	 * 5. �ۼ���       : 2020. 4. 12.
	 * @throws BMException 
	**/
	public ModelAndView selectBook(HttpServletRequest request) throws Exception {

		ModelAndView mav = new ModelAndView();
		int b_bno = Integer.parseInt(request.getParameter("b_bno"));
		Map<String, String> res = bs.selectBook(b_bno);
		mav.addObject("book", res);
		mav.setView("book/bookDetail");
		return mav;
	}
}
