/**
 * @PackageName: common.frontcontroller
 * @FileName : HandlerAdapter.java
 * @Date : 2020. 4. 13.
 * @프로그램 설명 : 
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
 * @프로그램 설명 : HandlerMapping의 결과에 따라 메서드를 실행
 * @author 
 */
public class HandlerAdapter {
	
	public ModelAndView excute(Controller ctr, String methodName, HttpServletRequest request) throws ServletException {
		
		ModelAndView mav = null;
		
		try {
			
			/*
			 * if(HttpServletRequest.class ==
			 * (Class.forName("javax.servlet.http.HttpServletRequest"))) {
			 * System.out.println("두 클래스 객체는 같다."); }else {
			 * System.out.println("두 클래스 객체는 다르다."); }
			 * 
			 * if(HttpServletRequest.class == request.getClass()) {
			 * System.out.println("두 클래스 객체는 같다."); }else {
			 * System.out.println("두 클래스 객체는 다르다."); }
			 */
			
			//Object클래스의 getClass 메서드로 배열로 받아온 객체의 클래스를 반환 받음
			Class<? extends Controller> c = ctr.getClass();
			
			//클래스 클래스가 가지고 있는 getDeclaredMethod()를 활용해서 
			//이름이 index인 메서드 객체를 반환, 매개변수가 있다면 매개변수의 클래스객체도 뒤에 넣어줘야한다.
			Method exMethod = c.getDeclaredMethod(methodName, HttpServletRequest.class);
			
			//메서드를 실행하고 ModelAndView 객체를 반환 받는다.
			
			mav = (ModelAndView)exMethod.invoke(ctr, request);
		
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e.getMessage());
		}
		
		return mav;
	}

}
