package common.frontcontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.util.FileUtil;

public class DispatcherServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	//서브 컨트롤러를 관리하는 객체
	HandlerMapping hm = new HandlerMapping();
	HandlerAdapter ha = new HandlerAdapter();   
	/**
     * @see HttpServlet#HttpServlet()
     */
	
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView();

		//클라이언트가 요청 보낸 URI를 저장
		String[] uriArr = request.getRequestURI().split("/");
		
			//Controller 실행
			mav = ha.excute(hm.getController(uriArr), hm.getMethod(uriArr), request);
					
			//view로 전송
			if(mav.getView().equals("ajax")) {
				PrintWriter pw = response.getWriter();
				String res = (String)mav.getData().get("res");
				pw.write(res);
				
			}else if(mav.getView().equals("file")) {
				
				FileUtil fu = new FileUtil();
				if(fu.fileDownload(mav, response)) {
					
				}else{
					mav.addObject("alertMsg", "파일다운로드에 실패하였습니다.");
					mav.addObject("url", "location.href");
					mav.setView("common/result");
					
					request.setAttribute("data", mav.getData());
					RequestDispatcher rd = request.getRequestDispatcher(mav.getView());
					rd.forward(request, response);
				};
				
			}else {
				request.setAttribute("data", mav.getData());
				RequestDispatcher rd = request.getRequestDispatcher(mav.getView());
				rd.forward(request, response);
			}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	

	
	
	
	
	
	
	
	
	
}
