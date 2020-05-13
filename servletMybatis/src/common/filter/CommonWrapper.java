package common.filter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class CommonWrapper extends HttpServletRequestWrapper {

	HttpServletRequest request;
	
	public CommonWrapper(HttpServletRequest request) {
		super(request);
		this.request = request;
	}
	
	//경로 지정
	public RequestDispatcher getRequestDispatcher(String view) {
		
		String uri =  "/WEB-INF/view/" + view + ".jsp";
		return request.getRequestDispatcher(uri);
	}
}
