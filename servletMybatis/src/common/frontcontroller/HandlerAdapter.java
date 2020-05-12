package common.frontcontroller;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HandlerAdapter {
	// 사용자로부터 해당 컨트롤러를 받아

	public ModelAndView excute(Controller ctr, String methodName, HttpServletRequest request) {

		ModelAndView mav = null;

		// Object클래스로 부터 상속받은 getClass 메서드를 사용해서 해당 객체의
		// Class 객체를 반환받는다.
		Class c = ctr.getClass();

		try {
			// 클래스 CLASS가 가지고 있는 getDeclaredMethod()를 활용해서
			// 이름이 methodName인 메서드 객체를 반환
			Method exMethod = c.getDeclaredMethod(methodName, HttpServletRequest.class);

			// 실행하고 결과를 반환 받는다.
			mav = (ModelAndView) exMethod.invoke(ctr, request);

		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mav;

	}

}
