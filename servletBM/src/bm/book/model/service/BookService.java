package bm.book.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bm.book.model.dao.BookDao;
import bm.book.model.vo.Book;
import common.JDBCTemplate;

public class BookService {

	private BookDao bDao = new BookDao();

	JDBCTemplate jdt = JDBCTemplate.getInstance();

	public List<Book> selectAllBookInfo() {

		List<Book> res = null;
		Connection conn = jdt.getConnection();

		try {
			res = bDao.selectAllBookInfo(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdt.close(conn);
		}

		return res;
	}

	public List<Book> bookSearch(String keyWord) {
		List<Book> searchList = new ArrayList<Book>();
		Connection conn = jdt.getConnection();

		try {
			searchList = bDao.bookSearch(conn, keyWord);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdt.close(conn);
		}

		return searchList;
	}

}
