/**
 * @PackageName: bm.book.model.dao
 * @FileName : BookDao.java
 * @Date : 2020. 4. 17.
 * @프로그램 설명 : 
 * @author 
 */
package bm.book.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import bm.book.model.vo.Book;
import common.JDBCTemplate;

/**
 * @PackageName: bm.book.model.dao
 * @FileName : BookDao.java
 * @Date : 2020. 4. 17.
 * @프로그램 설명 : 
 * @author 
 */
public class BookDao {
	JDBCTemplate jdt = JDBCTemplate.getInstance();

	public List<Book> selectBookList(SqlSession session, String title) throws Exception {

		return session.selectList("Book.selectBookList", title);
	}

	public Map<String, String> selectBook(SqlSession session, int b_bno) throws Exception {

		return session.selectOne("Book.selectBook", b_bno);
	}

}
