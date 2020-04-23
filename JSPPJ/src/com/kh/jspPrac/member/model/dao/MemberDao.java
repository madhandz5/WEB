package com.kh.jspPrac.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kh.jspPrac.member.model.vo.Member;

import common.JDBCTemplate;

public class MemberDao {

	private JDBCTemplate jdt = JDBCTemplate.getInstance();

	public int insertMember(Connection con, Member member) throws SQLException {
		PreparedStatement pstm = null;
		int res = 0;
		String sql = "INSERT INTO TB_MEMBER VALUES(?,?,1001,?,SYSDATE,'N')";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, member.getmId());
			pstm.setString(2, member.getmPwd());
			pstm.setString(3, member.getPhone());
			res = pstm.executeUpdate();
		} finally {
			jdt.close(pstm);
		}
		return res;
	}
}
