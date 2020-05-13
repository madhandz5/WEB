/**
 * @PackageName: bm.book.model.service
 * @FileName : BookService.java
 * @Date : 2020. 4. 17.
 * @프로그램 설명 : 
 * @author 
 */
package bm.book.model.service;

import java.sql.SQLException;
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
 * @프로그램 설명 : 
 * @author 
 */
public class BookService {

	BookDao bd = new BookDao();
	SqlSessionFactory factory = SqlMapConfig.getInstance();

	public List<Book> selectBookList(String title) throws Exception {

		List<Book> res = null;
		//Connection conn = jdt.getConnection();
		//openSession 의 매개변수로 false를 넣어야 auto commit이 안된다.
		SqlSession session = factory.openSession(false);

		try {
			res = bd.selectBookList(session, title);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BMException("도서 검색 중 에러가 발생했습니다.");
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
			throw new BMException("도서검색 중 에러가 발생했습니다.");
		} finally {
			session.close();
		}

		return res;
	}

}
