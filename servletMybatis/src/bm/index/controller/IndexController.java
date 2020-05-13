package bm.index.controller;

import javax.servlet.http.HttpServletRequest;
import common.frontcontroller.Controller;
import common.frontcontroller.ModelAndView;

/**
 * @PackageName: bm.index.controller
 * @FileName : IndexController.java
 * @Date : 2020. 4. 12.
 * @프로그램 설명 : 인덱스페이지 처리
 * @author 
 */
public class IndexController implements Controller{

	/**
	 * 1. MethodName : index
	 * 2. ClassName  : IndexController.java
	 * 3. Comment    : 인덱스 페이지 처리
	 * 4. 작성자       : 하명도
	 * 5. 작성일       : 2020. 4. 12.
	**/     
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setView("index/index");
		return mav;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
