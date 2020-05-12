package bm.notice.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.print.DocFlavor.STRING;

import bm.notice.model.vo.Notice;
import common.JDBCTemplate;
import common.util.Paging;

public class NoticeDao {

	JDBCTemplate jdt = JDBCTemplate.getInstance();

	public List<Notice> selectNoticeList(Connection conn, Paging p, String orderby) throws SQLException {
		List<Notice> nList = new ArrayList<Notice>();
		Notice notice = null;

		String sql = "select * from (select rownum rnum, n1.* from (select * from tb_notice	order by " + orderby
				+ " desc) n1)	where rnum between ? and ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, p.getStart());
			pstmt.setInt(2, p.getEnd());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				notice = new Notice();
				notice.setNoticeNo(rs.getInt(2));
				notice.setNoticeTitle(rs.getString(3));
				notice.setNoticeDate(rs.getDate(4));
				notice.setNoticeContent(rs.getString(5));
				nList.add(notice);
			}
		} finally {
			jdt.close(rs, pstmt);
		}

		return nList;
	}

	public int contentCnt(Connection conn) throws SQLException {
		int res = 0;
		String sql = "select count(*) from tb_notice";
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				res = rs.getInt(1);
			}
		} finally {
			jdt.close(rs, stmt);
		}
		return res;
	}

	public int noticeUpload(Connection conn, Notice notice) throws SQLException {
		int res = 0;

		PreparedStatement pstm = null;
		String sql = "INSERT INTO TB_NOTICE VALUES(S_NOTICE.NEXTVAL,?,sysdate,?,?,?,?)";

		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, notice.getNoticeTitle());
			pstm.setString(2, notice.getNoticeWriter());
			pstm.setString(3, notice.getNoticeContent());
			pstm.setString(4, notice.getOriginal_filepath());
			pstm.setString(5, notice.getRename_filepath());
			res = pstm.executeUpdate();
		} finally {
			jdt.close(pstm);
		}
		return res;
	}

	public Notice noticeDetail(Connection conn, int noticeNo) throws SQLException {
		Notice notice = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from tb_notice where noticeno = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, noticeNo);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				notice = new Notice();
				notice.setNoticeNo(rs.getInt(1));
				notice.setNoticeTitle(rs.getString(2));
				notice.setNoticeDate(rs.getDate(3));
				notice.setNoticeWriter(rs.getString(4));
				notice.setNoticeContent(rs.getString(5));
				notice.setOriginal_filepath(rs.getString(6));
				notice.setRename_filepath(rs.getString(7));
			}

		} finally {
			jdt.close(rs, pstmt);
		}

		return notice;
	}
}
