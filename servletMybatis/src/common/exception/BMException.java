package common.exception;

import javax.servlet.ServletException;

//ServletException을 상속받아야 web.xml의 에러페이지 설정을 사용할 수 있다.
public class BMException extends ServletException {

	public BMException(String message) {
		super(message);
	}
}
