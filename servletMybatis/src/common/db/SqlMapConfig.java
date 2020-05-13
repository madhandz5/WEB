/**
 * @PackageName: common.db
 * @FileName : sqlConfig.java
 * @Date : 2020. 5. 10.
 * @���α׷� ���� : 
 * @author 
 */
package common.db;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


/**
 * @PackageName: common.db
 * @FileName : sqlConfig.java
 * @Date : 2020. 5. 10.
 * @���α׷� ���� : 
 * @author 
 */
public class SqlMapConfig {
	
	//singleton ���
	//�� �ϳ��� �ν��Ͻ��� ����� ���� ������ ����
	//�ν��Ͻ��� �ʿ��� �� ���� �Ź� ���� �ν��Ͻ��� ��ȯ�Ѵ�.
	//�����ڰ� ���� ���� ȣ��Ǵ��� ������ �����Ǵ� ��ü�� �ϳ��� ���� ���� ���Ŀ� ȣ��� �����ڴ� ���ʿ� ������ ��ü�� ��ȯ�Ѵ�. 
	//(�ڹٿ��� �����ڸ� private�� �����ؼ� ���� �Ұ��ϰ� �ϰ� getInstance()�� �޾ƾ��⵵ ��)
	
	//Initialization on demand holder idiom (holder�� ���� �ʱ�ȭ)
	//����Ŭ������ ������ static�̴��� �ʱ�ȭ ���� �ʴ´�.
	//getInstance �޼��尡 ȣ��� �� ���� JDBCTemplate ��ü�� �������� �ʴ´�.
	private static class SqlSessionFactoryHolder{
		
	  //����� SqlSessionFactory��ü�� ��´�.	
	  //�ѹ� �ʱ�ȭ ���Ŀ��� = getSqlSessionFactory(); �ڵ尡 ������� ����.
	  //static�̱� ������ instance�� �޸𸮿��� �������� �ʴ´�.
      //����̱� ������ �ѹ� �ʱ�ȭ �� ���ķδ� �ٽ� ���� ���� �ʴ´�. �����弼�����ϴ�.
	  
		private static final SqlSessionFactory instance = getSqlSessionFactory();
	
	}
	
	public static SqlSessionFactory getInstance() {
		return SqlSessionFactoryHolder.instance;
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		
		System.out.println("getSqlSessionFactory?");
		SqlSessionFactory sqlSessionFactory = null;
		String resource = "common/db/mybatis-config.xml";
		
		try {
			Reader reader = Resources.getResourceAsReader(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sqlSessionFactory;
	}

}
