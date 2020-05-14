/**
 * @PackageName: bm.book.model.service
 * @FileName : BookService.java
 * @Date : 2020. 4. 17.
 * @���α׷� ���� : 
 * @author 
 */
package bm.book.model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bm.book.model.dao.BookDao;
import bm.book.model.vo.Book;
import common.db.SqlMapConfig;
import common.exception.BMException;

/**
 * @PackageName: bm.book.model.service
 * @FileName : BookService.java
 * @Date : 2020. 4. 17.
 * @���α׷� ���� : 
 * @author 
 */
public class BookService {

	BookDao bd = new BookDao();
	SqlSessionFactory factory = SqlMapConfig.getInstance();

	public List<Book> selectBookList(String title) throws Exception {

		List<Book> res = null;
		//Connection conn = jdt.getConnection();
		//openSession �� �Ű������� false�� �־�� auto commit�� �ȵȴ�.
		SqlSession session = factory.openSession(false);

		try {
			res = bd.selectBookList(session, title);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BMException("���� �˻� �� ������ �߻��߽��ϴ�.");
		} finally {
			session.close();
		}

		return res;
	}

	public Map<String, String> selectBook(int b_bno) throws Exception {

		Map<String, String> res = null;
		SqlSession session = factory.openSession(false);

		try {
			res = bd.selectBook(session, b_bno);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BMException("�����˻� �� ������ �߻��߽��ϴ�.");
		} finally {
			session.close();
		}

		return res;
	}

	public List<Book> selectInnerBookSearchList(Map<String, Object> commandMap) throws BMException {
		List<Book> res = new ArrayList<>();
		SqlSession session = factory.openSession(false);

		try {
			res = bd.selectInnerBookSearchList(session, commandMap);
		} catch (Exception e) {
			e.printStackTrace();
			new BMException("���� ��˻����� ������ �߻��Ͽ����ϴ�.");
		} finally {
			session.close();
		}

		return res;
	}

}
