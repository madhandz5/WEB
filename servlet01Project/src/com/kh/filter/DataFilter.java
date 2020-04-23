package com.kh.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class DataFilter
 */
public class DataFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public DataFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("필터가 파괴 되었습니다.");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */

	// FilterChain : filter들의 연결, 제일 마지막에는 클라이언트가 요청한 자원의 경로가 된다.
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		response.setContentType("image/jpg");
		request.setCharacterEncoding("UTF-8");
		System.out.println("DATA FILTER");

		DataWrapper dw = new DataWrapper((HttpServletRequest) request);

		// FilterChain 내부의 다음 Filter로 request, response 전달
		chain.doFilter(dw, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("필터가 생성되었습니다.");
	}

}
