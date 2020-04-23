package bm.notice.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bm.notice.model.dao.NoticeDao;
import bm.notice.model.vo.Notice;
import common.JDBCTemplate;
import common.util.Paging;

public class NoticeService {

	JDBCTemplate jdt = JDBCTemplate.getInstance();
	NoticeDao nDao = new NoticeDao();

	public Map<String, Object> selectNoticeList(String orderby, int currentPage, int cntPerPage) {
		Map<String, Object> res = new HashMap<String, Object>();
		Connection conn = jdt.getConnection();
		Paging p = null;
		List<Notice> nList = null;

		try {
			p = new Paging(nDao.contentCnt(conn), currentPage, cntPerPage);
			nList = nDao.selectNoticeList(conn, p, orderby);
			res.put("paging", p);
			res.put("nList", nList);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdt.close(conn);
		}

		return res;
	}

	public int noticeUpload(Notice notice) {
		int res = 0;
		Connection conn = jdt.getConnection();

		try {
			res = nDao.noticeUpload(conn, notice);
			if (res >= 1) {
				jdt.commit(conn);
			} else {
				jdt.rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdt.close(conn);
		}
		return res;
	}

	public Notice noticeDetail(int noticeNo) {
		Notice notice = null;
		Connection conn = jdt.getConnection();

		try {
			notice = nDao.noticeDetail(conn, noticeNo);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdt.close(conn);
		}

		return notice;
	}

}
