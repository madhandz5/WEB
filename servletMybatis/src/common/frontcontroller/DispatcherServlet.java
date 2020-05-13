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
	
	//���� ��Ʈ�ѷ��� �����ϴ� ��ü
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

		//Ŭ���̾�Ʈ�� ��û ���� URI�� ����
		String[] uriArr = request.getRequestURI().split("/");
		
			//Controller ����
			mav = ha.excute(hm.getController(uriArr), hm.getMethod(uriArr), request);
					
			//view�� ����
			if(mav.getView().equals("ajax")) {
				PrintWriter pw = response.getWriter();
				String res = (String)mav.getData().get("res");
				pw.write(res);
				
			}else if(mav.getView().equals("file")) {
				
				FileUtil fu = new FileUtil();
				if(fu.fileDownload(mav, response)) {
					
				}else{
					mav.addObject("alertMsg", "���ϴٿ�ε忡 �����Ͽ����ϴ�.");
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
