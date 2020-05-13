/**
 * @PackageName: common.frontcontroller
 * @FileName : HandlerAdapter.java
 * @Date : 2020. 4. 13.
 * @���α׷� ���� : 
 * @author 
 */
package common.frontcontroller;

import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 * @PackageName: common.frontcontroller
 * @FileName : HandlerAdapter.java
 * @Date : 2020. 4. 13.
 * @���α׷� ���� : HandlerMapping�� ����� ���� �޼��带 ����
 * @author 
 */
public class HandlerAdapter {
	
	public ModelAndView excute(Controller ctr, String methodName, HttpServletRequest request) throws ServletException {
		
		ModelAndView mav = null;
		
		try {
			
			/*
			 * if(HttpServletRequest.class ==
			 * (Class.forName("javax.servlet.http.HttpServletRequest"))) {
			 * System.out.println("�� Ŭ���� ��ü�� ����."); }else {
			 * System.out.println("�� Ŭ���� ��ü�� �ٸ���."); }
			 * 
			 * if(HttpServletRequest.class == request.getClass()) {
			 * System.out.println("�� Ŭ���� ��ü�� ����."); }else {
			 * System.out.println("�� Ŭ���� ��ü�� �ٸ���."); }
			 */
			
			//ObjectŬ������ getClass �޼���� �迭�� �޾ƿ� ��ü�� Ŭ������ ��ȯ ����
			Class<? extends Controller> c = ctr.getClass();
			
			//Ŭ���� Ŭ������ ������ �ִ� getDeclaredMethod()�� Ȱ���ؼ� 
			//�̸��� index�� �޼��� ��ü�� ��ȯ, �Ű������� �ִٸ� �Ű������� Ŭ������ü�� �ڿ� �־�����Ѵ�.
			Method exMethod = c.getDeclaredMethod(methodName, HttpServletRequest.class);
			
			//�޼��带 �����ϰ� ModelAndView ��ü�� ��ȯ �޴´�.
			
			mav = (ModelAndView)exMethod.invoke(ctr, request);
		
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e.getMessage());
		}
		
		return mav;
	}

}
