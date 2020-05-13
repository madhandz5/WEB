/**
 * @PackageName: common.db
 * @FileName : sqlConfig.java
 * @Date : 2020. 5. 10.
 * @프로그램 설명 : 
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
 * @프로그램 설명 : 
 * @author 
 */
public class SqlMapConfig {
	
	//singleton 방식
	//단 하나의 인스턴스만 만들어 쓰는 디자인 패턴
	//인스턴스가 필요할 때 마다 매번 같은 인스턴스를 반환한다.
	//생성자가 여러 차례 호출되더라도 실제로 생성되는 객체는 하나고 최초 생성 이후에 호출된 생성자는 최초에 생성한 객체를 반환한다. 
	//(자바에선 생성자를 private로 선언해서 생성 불가하게 하고 getInstance()로 받아쓰기도 함)
	
	//Initialization on demand holder idiom (holder에 의한 초기화)
	//내부클래스에 있으면 static이더라도 초기화 되지 않는다.
	//getInstance 메서드가 호출될 때 까지 JDBCTemplate 객체는 생성되지 않는다.
	private static class SqlSessionFactoryHolder{
		
	  //상수에 SqlSessionFactory객체를 담는다.	
	  //한번 초기화 이후에는 = getSqlSessionFactory(); 코드가 실행되지 않음.
	  //static이기 때문에 instance가 메모리에서 내려가지 않는다.
      //상수이기 때문에 한번 초기화 된 이후로는 다시 값을 담지 않는다. 쓰래드세이프하다.
	  
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
