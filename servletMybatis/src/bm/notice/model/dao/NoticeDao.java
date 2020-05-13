
package bm.notice.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import bm.notice.model.vo.Notice;
import common.JDBCTemplate;
import common.util.Paging;

public class NoticeDao {

	JDBCTemplate jdt = JDBCTemplate.getInstance();

	public NoticeDao() {
	}

	public int insertNotice(SqlSession session, Notice n) throws SQLException {

		return session.insert("Notice.insertNotice", n);
	}

	public List<Notice> selectNoticeList(SqlSession session, Paging p, String orderby) throws Exception {

		Map<String, Object> commandMap = new HashMap<String, Object>();
		commandMap.put("start", p.getStart());
		commandMap.put("end", p.getEnd());
		commandMap.put("orderBy", orderby);

		return session.selectList("Notice.selectNoticeList", commandMap);
	}

	public int deleteNotice(SqlSession session, int noticeNo) throws Exception {

		return session.delete("Notice.deleteNotice", noticeNo);
	}

	public Notice noticeDetail(SqlSession session, int noticeNo) throws Exception {

		return session.selectOne("Notice.selectNoticeDetail", noticeNo);
	}

	public int contentCnt(SqlSession session) throws Exception {

		return session.selectOne("Notice.contentCnt");
	}
}
