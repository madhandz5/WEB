package bm.notice.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import bm.member.model.vo.Member;
import bm.notice.model.service.NoticeService;
import bm.notice.model.vo.Notice;
import common.frontcontroller.Controller;
import common.frontcontroller.ModelAndView;
import common.util.FileUtil;
import common.vo.UploadFile;

public class NoticeController implements Controller {

	NoticeService ns = new NoticeService();

	public ModelAndView noticeList(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		int currentPage = 1;
		int cntPerPage = 5;
		String orderby = "noticeno";

		Map<String, Object> res = ns.selectNoticeList(orderby, currentPage, cntPerPage);
		mav.addObject("paging", res.get("paging"));
		mav.addObject("nData", res.get("nList"));
		mav.setView("board/boardList");

		if (request.getParameter("cPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("cPage"));
		}

		if (request.getParameter("cntPerPage") != null) {
			cntPerPage = Integer.parseInt(request.getParameter("cntPerPage"));
		}

		return mav;
	}

	public ModelAndView noticeUpload(HttpServletRequest request) throws IOException {
		ModelAndView mav = new ModelAndView();
		Member member = (Member) request.getSession().getAttribute("loginInfo");

		String uploadFolder = "resources/upload";
		UploadFile uf = new FileUtil().fileUpload(uploadFolder, request);

		if (uf.isSuccess()) {
			mav.addObject("alertMsg", "게시물 등록이 성공되었습니다.");
			Notice notice = new Notice();
			notice.setNoticeTitle(uf.getMrequest().getParameter("noticeTitle"));
			notice.setNoticeContent(uf.getMrequest().getParameter("noticeContent"));
			notice.setNoticeWriter(member.getM_id());
			notice.setOriginal_filepath(uf.getOriginalFileName());
			notice.setRename_filepath(uf.getRenameFileName());

			if (ns.noticeUpload(notice) > 0) {
				mav.addObject("alertMsg", "게시물 등록이 성공하였습니다.");
				mav.addObject("url", "/servletBM/notice/noticelist.do");
				mav.setView("common/result");
			} else {
				mav.addObject("alertMsg", "게시물 등록이 실패하였습니다.");
				mav.addObject("back", "back");
				mav.setView("common/result");
			}
			mav.setView("common/result");
		}
		return mav;
	}

	public ModelAndView noticeWrite(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();

		mav.setView("board/boardForm");
		return mav;
	}

	public ModelAndView noticeDetail(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		Notice notice = ns.noticeDetail(noticeNo);

		mav.addObject("notice", notice);
		mav.setView("board/boardView");
		return mav;
	}

	public ModelAndView noticeDownload(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();

		String readFolder = request.getSession().getServletContext().getRealPath("/resources/upload");

		String path = readFolder + "/" + request.getParameter("rfname");

		String ofname = request.getParameter("ofname");

		mav.addObject("path", path);
		mav.addObject("obname", ofname);
		mav.setView("file");
		
		return mav;

	}

}
