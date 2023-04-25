package util;
//SqlSessionFactory 까지 받아오는 기능을 설정

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class FactoryService {
	private static SqlSessionFactory factory = null;
	static {
		try {
			//2. MyBatis 핵심 설정문서를 읽어들인다
			Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
			
			//3. SqlSessionFactory 생성
			factory = new SqlSessionFactoryBuilder().build(r);
		}catch(IOException e) {
			System.out.println(e);
		}
	}//static
	public static SqlSessionFactory getFactory() {
		return factory;
		
	}
}
