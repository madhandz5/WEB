package common.frontcontroller;

import java.util.HashMap;

import bm.book.controller.BookController;
import bm.index.controller.IndexController;
import bm.member.controller.MemberController;
import bm.mypage.controller.MyPageController;
import bm.notice.controller.NoticeController;
import bm.use.controller.UseController;
import common.exception.Status404;

public class HandlerMapping {

	private HashMap<String, Controller> list = null;

	public HandlerMapping() {

		list = new HashMap<String, Controller>();
		list.put("book", new BookController());
		list.put("index", new IndexController());
		list.put("member", new MemberController());
		list.put("mypage", new MyPageController());
		list.put("use", new UseController());
		list.put("notice", new NoticeController());

	}

	public Controller getController(String[] uriArr) throws Status404 {

		Controller res = list.get(uriArr[2]);
		if (res == null) {
			throw new Status404("uri를 다시 확인해주세요");
		}
		return res;
	}

	public String getMethod(String[] uriArr) throws Status404 {

		String methodName = "";

		switch (uriArr[2]) {
		case "index":
			switch (uriArr[3]) {
			case "index.do":
				methodName = "index";
				break;
			default:
				throw new Status404("uri를 다시 확인해주세요");
			}
			break;
		case "member":
			switch (uriArr[3]) {
			case "join.do":
				methodName = "join";
				break;
			case "joinemailcheck.do":
				methodName = "joinEmailCheck";
				break;
			case "joinimple.do":
				methodName = "joinImple";
				break;
			case "idcheck.do":
				methodName = "idCheck";
				break;
			case "login.do":
				methodName = "login";
				break;
			case "loginimple.do":
				methodName = "loginImple";
				break;
			case "logoutimple.do":
				methodName = "logoutImple";
				break;
			case "modifypw.do":
				methodName = "modifyPw";
				break;

			default:
				throw new Status404("uri를 다시 확인해주세요");
			}
			break;
		case "mypage":
			switch (uriArr[3]) {
			case "mypage.do":
				methodName = "myPage";
				break;
			default:
				throw new Status404("uri를 다시 확인해주세요");
			}
			break;

		case "notice":
			switch (uriArr[3]) {
			case "upload.do":
				methodName = "noticeUpload";
				break;
			case "noticewrite.do":
				methodName = "noticeWrite";
				break;
			case "noticelist.do":
				methodName = "noticeList";
				break;
			case "noticedetail.do":
				methodName = "noticeDetail";
				break;
			case "noticedownload.do":
				methodName = "noticeDownload";
				break;
			default:
				throw new Status404("uri를 다시 확인해주세요");
			}
			break;

		case "book":
			switch (uriArr[3]) {
			case "booksearch.do":
				methodName = "bookSearch";
				break;
			default:
				throw new Status404("uri를 다시 확인해주세요");
			}
			break;
		case "use":
			break;

		default:
			throw new Status404("uri를 다시 확인해주세요");
		}

		return methodName;

	}

}
