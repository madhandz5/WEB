package bm.notice.model.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.openqa.selenium.remote.Command;

import bm.notice.model.dao.NoticeDao;
import bm.notice.model.vo.Notice;
import common.JDBCTemplate;
import common.db.SqlMapConfig;
import common.exception.BMException;
import common.frontcontroller.ModelAndView;
import common.util.Paging;

public class NoticeService {

	JDBCTemplate jdt = JDBCTemplate.getInstance();
	SqlSessionFactory factory = SqlMapConfig.getInstance();

	NoticeDao ndao = new NoticeDao();

	public NoticeService() {
	}

	public int insertNotice(Notice n) {
		SqlSession session = factory.openSession(false);
		int result = 0;
		try {
			result = ndao.insertNotice(session, n);
			session.commit();
		} catch (SQLException e) {
			session.rollback();
			e.printStackTrace();
			new BMException(e.getMessage());
		} finally {
			session.close();
		}

		return result;
	}

	public int deleteNotice(int noticeNo) {

		SqlSession session = factory.openSession(false);
		int result = 0;
		try {
			result = ndao.deleteNotice(session, noticeNo);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
			new BMException(e.getMessage());
		} finally {
			session.close();
		}

		return result;
	}

	public Map<String, Object> selectNoticeList(String orderby, int currentPage, int cntPerPage) throws Exception {

		Map<String, Object> res = null;
		SqlSession session = factory.openSession(false);
		List<Notice> nlist = null;
		Paging p = null;

		try {
			p = new Paging(ndao.contentCnt(session), currentPage, cntPerPage);
			nlist = ndao.selectNoticeList(session, p, orderby);
			res.put("res", res);

		} catch (Exception e) {
			e.printStackTrace();
			new BMException(e.getMessage());
		} finally {
			session.close();
		}

		return res;
	}

	public Notice noticeDetail(int noticeNo) throws Exception {
		SqlSession session = factory.openSession(false);
		Notice notice = new Notice();

		try {
			notice = ndao.noticeDetail(session, noticeNo);
		} finally {
			session.close();
		}

		return notice;

	}
}
