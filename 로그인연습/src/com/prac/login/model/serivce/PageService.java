package com.prac.login.model.serivce;

import java.sql.Connection;
import java.sql.SQLException;

import com.prac.login.model.dao.PageDao;
import com.prac.login.model.vo.Member;

import common.JDBCTemplate;

public class PageService {

	JDBCTemplate jdt = JDBCTemplate.getInstance();
	PageDao pd = new PageDao();

	public int memberLogin(Member member) {
		Connection con = jdt.getConnection();
		int res = 0;
		try {
			res = pd.memberLogin(con, member);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("로그인 실패!");
		}
		return res;
	}

	public int memberJoin(Member member) {
		Connection con = jdt.getConnection();
		int res = 0;
		try {
			res = pd.memberJoin(con, member);
			jdt.commit(con);
		} catch (SQLException e) {
			e.printStackTrace();
			jdt.rollback(con);
		}
		return res;
	}

}
