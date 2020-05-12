package bm.member.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bm.member.model.vo.Member;
import common.db.SqlMapConfig;

@WebServlet("/")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SqlSessionFactory factory = SqlMapConfig.getInstance();

		try (SqlSession session = factory.openSession()) {
			List<Map> res = null;
			String m_id = "asfaf";

			//vo 에 담아서 넘기기
			Member member = new Member();
			member.setM_id("asfaf");

			//map에 담아서 넘기기
			Map<String, String> mapData = new HashMap<>();
			//			mapData.put("m_id", "asfaf");
			mapData.put("tableName", "tb_book");

			//			res = session.selectList("Member.selectMember",mapData);
			res = session.selectList("Member.selectBook", mapData);
			for (Map m : res) {
				System.out.println(m);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
