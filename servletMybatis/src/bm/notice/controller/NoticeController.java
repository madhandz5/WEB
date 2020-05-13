/**
 * @PackageName: bm.notice.controller
 * @FileName : NoticeController.java
 * @Date : 2020. 4. 20.
 * @���α׷� ���� : 
 * @author 
 */
package bm.notice.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import bm.notice.model.service.NoticeService;
import bm.notice.model.vo.Notice;
import common.frontcontroller.Controller;
import common.frontcontroller.ModelAndView;
import common.util.FileUtil;
import common.util.UploadFile;

/**
 * @PackageName: bm.notice.controller
 * @FileName : NoticeController.java
 * @Date : 2020. 4. 20.
 * @���α׷� ���� : 
 * @author 
 */
public class NoticeController implements Controller {

	private NoticeService ns = new NoticeService();

	public ModelAndView noticeList(HttpServletRequest request) throws Exception {

		ModelAndView mav = new ModelAndView();

		int currentPage = 1;
		int cntPerPage = 10;
		String orderby = "noticeno";

		if (request.getParameter("cPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("cPage"));
		}

		if (request.getParameter("cntPerPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("cntPerPage"));
		}

		Map<String, Object> res = ns.selectNoticeList(orderby, currentPage, cntPerPage);
		mav.addObject("paging", res.get("paging"));
		System.out.println(res.get("paging"));

		mav.addObject("mdata", res);
		mav.setView("board/boardList");

		return mav;
	}

	public ModelAndView noticeDetail(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();

		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		Notice notice = ns.noticeDetail(noticeNo);

		if (notice != null) {
			mav.setView("board/boardView");
			mav.addObject("notice", notice);
		} else {
			mav.setView("index/index");
		}

		return mav;
	}

	public ModelAndView noticeWrite(HttpServletRequest request) throws IOException {

		ModelAndView mav = new ModelAndView();
		mav.setView("board/boardForm");
		return mav;
	}

	public ModelAndView noticeUpload(HttpServletRequest request) throws IOException {

		ModelAndView mav = new ModelAndView();

		String writer = request.getParameter("writer");

		// ���ε�Ǵ� ������ ����� ������� ��� ���� ó��
		String uploadFolder = "resources/upload";
		UploadFile file = new FileUtil().fileUpload(uploadFolder, request);

		Notice notice = new Notice();
		notice.setNoticeTitle(file.getMrequest().getParameter("noticeTitle"));
		notice.setNoticeWriter(file.getMrequest().getParameter("noticeWriter"));
		notice.setNoticePassword(file.getMrequest().getParameter("noticePassword"));
		notice.setNoticeContent(file.getMrequest().getParameter("noticeContent"));
		notice.setNoticeWriter(writer);
		notice.setOriginal_filepath(file.getOriginalFilename());
		notice.setRename_filepath(file.getRenameFileName());

		if (ns.insertNotice(notice) > 0) {
			mav.addObject("alertMsg", "�Խù��� ���������� ��ϵǾ����ϴ�.");
			mav.addObject("url", "/servletBM/notice/noticelist.do");
			mav.setView("common/result");
		} else {
			mav.addObject("alertMsg", "�Խù� ��Ͽ� �����Ͽ����ϴ�.");
			mav.addObject("back", "back");
			mav.setView("common/result");
		}

		return mav;
	}

	public ModelAndView noticeDelete(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		ns.deleteNotice(noticeNo);
		mav.setView("board/boardView");

		return mav;
	}

}
