package common.exception;

import javax.servlet.ServletException;

//ServletException�� ��ӹ޾ƾ� web.xml�� ���������� ������ ����� �� �ִ�.
public class BMException extends ServletException {

	public BMException(String message) {
		super(message);
	}
}
