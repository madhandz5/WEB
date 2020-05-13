/**
 * @PackageName: common.frontcontroller
 * @FileName : HandlerMapping.java
 * @Date : 2020. 4. 12.
 * @프로그램 설명 : 
 * @author 
 */
package common.frontcontroller;

import java.util.HashMap;

import bm.book.controller.BookController;
import bm.index.controller.IndexController;
import bm.notice.controller.NoticeController;
import common.exception.Status404;

/**
 * @PackageName: common.frontcontroller
 * @FileName : HandlerMapping.java
 * @Date : 2020. 4. 12.
 * @프로그램 설명 : 요청온 uri에 따른 컨트롤러와 메서드 설정
 * @author 
 */
public class HandlerMapping {
	
	private HashMap<String, Controller> list = null;
	
	public HandlerMapping() {
		
		// 서브 컨트롤러 에 대한 정보를 가지는 객체
        list = new HashMap<String, Controller>();
        // 서브 컨트롤러 연결 및 매핑
        list.put("index", new IndexController()); 
        list.put("book", new BookController()); 
        list.put("notice", new NoticeController());
	}
	
	public Controller getController(String[] uriArr) throws Status404 {
		
		Controller res = list.get(uriArr[2]);
		
		if(res == null) {
			throw new Status404("uri를 다시 확인해 주세요");
		}
		
		return res;
	}
	
	public String getMethod(String[] uriArr) throws Status404 {
		
		String methodName = "";
		switch(uriArr[2]){
			case "index" : 
				switch(uriArr[3]) {
					case "index.do" :  methodName = "index";
					break; 
					default : throw new Status404("uri를 다시 확인해 주세요");
				}
				
			break;
		
			case "book" :
				switch(uriArr[3]) {
				case "search.do" :  methodName = "selectBookList";
					break;
				case "detail.do" :  methodName = "selectBook";
					break;
				default : throw new Status404("uri를 다시 확인해 주세요");
			}
		
			break;
				
			case "notice" :
				switch(uriArr[3]) {
				case "upload.do" :  methodName = "noticeUpload";
					break;
				case "noticelist.do" :  methodName = "noticeList";
					break;
				case "noticedetail.do" :  methodName = "noticeDetail";
					break;
				case "noticedownload.do" :  methodName = "noticeDownload";
					break;
				case "noticewrite.do" :  methodName = "noticeWrite";
					break;
				default : throw new Status404("uri를 다시 확인해 주세요");
				}
				
			break;
			default : throw new Status404("uri를 다시 확인해 주세요");
		}
		
		return methodName;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
