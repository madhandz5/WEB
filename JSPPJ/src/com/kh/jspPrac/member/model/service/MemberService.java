package com.kh.jspPrac.member.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.kh.jspPrac.member.model.dao.MemberDao;
import com.kh.jspPrac.member.model.vo.Member;

import common.JDBCTemplate;
import exception.BookException;

public class MemberService {

	private MemberDao mDao = new MemberDao();
	JDBCTemplate jdt = JDBCTemplate.getInstance();

	public void insertMember(Member member) throws BookException {
		Connection conn = jdt.getConnection();

		try {
			mDao.insertMember(conn, member);
			jdt.commit(conn);
		} catch (SQLException e) {
			jdt.rollback(conn);
			throw new BookException(e.getMessage());
		}
	}
}
