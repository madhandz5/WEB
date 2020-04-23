package com.kh.common;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.PropertyConfigurator;

/**
 * Servlet implementation class Log4jInit
 */
// @WebServlet("/Log4jInit")
public class Log4jInit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	// <load-on-startup>1</load-on-startup>
	// <load-on-startup> : 할당된 값이 양수이면 서버가 실행될 때 메모리에 서블릿을 올린다.
	// <load-on-startup> : 이 설정된 서블릿이 많다면, 숫자가 적게 설정된 서블릿부터 메모리에 올라간다.
	public Log4jInit() {
		super();
	}

	public void init() throws ServletException {
		super.init();

		// WEB 폴더!
		String prefix = getServletContext().getRealPath("/");
		String file = getInitParameter("logProp");
		PropertyConfigurator.configure(prefix + file);
	}
}
