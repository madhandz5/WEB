package common.db;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapConfig {

	// Singleton ���
	// �� �ϳ��� �ν��Ͻ��� ���� ����ϴ� ������ ����
	// �ν��Ͻ��� �ʿ��� ������ �Ź� ���� �ν��Ͻ��� ���
	// �����ڸ� private���� ������ ������ �Ұ��ϰ� �ϰ�
	// �ν��Ͻ��� ��ȯ���ִ� getInstance() �޼��带 �����.

	// Initialization on demand holder idiom
	// (holder�� ���� �ʱ�ȭ ���)

	// ���� Ŭ������ �����ϰ�, ���� Ŭ������ ��� �ʵ� ������ �ν��Ͻ��� ��´�.
	// �ʿ��� �� ���� ��� �ʵ庯���� ��� ��ü�� ��ȯ���ش�.

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
