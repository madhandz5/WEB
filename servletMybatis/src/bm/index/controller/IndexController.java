package bm.index.controller;

import javax.servlet.http.HttpServletRequest;
import common.frontcontroller.Controller;
import common.frontcontroller.ModelAndView;

/**
 * @PackageName: bm.index.controller
 * @FileName : IndexController.java
 * @Date : 2020. 4. 12.
 * @���α׷� ���� : �ε��������� ó��
 * @author 
 */
public class IndexController implements Controller{

	/**
	 * 1. MethodName : index
	 * 2. ClassName  : IndexController.java
	 * 3. Comment    : �ε��� ������ ó��
	 * 4. �ۼ���       : �ϸ�
	 * 5. �ۼ���       : 2020. 4. 12.
	**/     
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setView("index/index");
		return mav;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
