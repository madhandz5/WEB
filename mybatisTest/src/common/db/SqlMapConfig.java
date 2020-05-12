package common.db;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapConfig {

	// Singleton 방식
	// 단 하나의 인스턴스만 만들어서 사용하는 디자인 패턴
	// 인스턴스가 필요할 때마다 매번 같은 인스턴스를 사용
	// 생성자를 private으로 선언해 생성이 불가하게 하고
	// 인스턴스를 반환해주는 getInstance() 메서드를 만든다.

	// Initialization on demand holder idiom
	// (holder에 의한 초기화 방식)

	// 내부 클래스를 생성하고, 내부 클래스의 상수 필드 변수에 인스턴스를 담는다.
	// 필요할 때 마다 상수 필드변수에 담긴 객체를 반환해준다.

	private static class SqlSessionFactoryHolder {
		private static final SqlSessionFactory INSTANCE = createSqlSessionFactory();
	}

	private static SqlSessionFactory createSqlSessionFactory() {

		System.out.println("createSqlSessionFactory?");
		String resource = "common/db/mybatis-config.xml";
		InputStream inputStream;
		SqlSessionFactory sqlSessionFactory = null;

		try {

			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return sqlSessionFactory;
	}

	public static SqlSessionFactory getInstance() {
		return SqlSessionFactoryHolder.INSTANCE;
	}

}
