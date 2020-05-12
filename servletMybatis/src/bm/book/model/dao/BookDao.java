package bm.book.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import bm.book.model.vo.Book;
import common.JDBCTemplate;

public class BookDao {

	JDBCTemplate jdt = JDBCTemplate.getInstance();

	public List<Book> selectAllBookInfo(Connection conn) throws SQLException {

		List<Book> res = new ArrayList<>();

		Statement stmt = null;
		ResultSet rs = null;

		String sql = "select * from tb_book";

		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);

		try {
			while (rs.next()) {

				Book b = new Book();

				b.setbTitle(rs.getString(3));
				b.setbAuthor(rs.getString(4));
				b.setbIsbn(rs.getString(8));

				res.add(b);
			}
		} finally {
			jdt.close(rs, stmt);
		}

		return res;
	}

	public List<Book> bookSearch(Connection conn, String keyWord) throws SQLException {

		List<Book> searchList = new ArrayList<Book>();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from tb_book where b_title like '%" + keyWord + "%'";

		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Book book = new Book();
				book.setbBno(rs.getInt(1));
				book.setbCategory(rs.getInt(2));
				book.setbTitle(rs.getString(3));
				book.setbAuthor(rs.getString(4));
				book.setbRegDate(rs.getDate(5));
				book.setbRentYN(rs.getString(6));
				book.setbRentCnt(rs.getInt(7));
				book.setbIsbn(rs.getString(8));
				searchList.add(book);
			}
		}finally {
			jdt.close(rs, stmt);
		}

		return searchList;
	}

}
