package com.service.mybatis.client;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.service.mybatis.vo.MySawon;

public class MySawonAppTest02 {

	public static void main(String[] args) throws Exception{
		
		//2. MyBatis 핵심 설정문서를 읽어들인다
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		//3. SqlSessionFactory 생성
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		
		//4. SqlSession 생성
		SqlSession session = factory.openSession();
		System.out.println("SqlSession Creating...");

		//5.
		List<MySawon> list = session.selectList("sawonMapper.sawonList");
		for(MySawon v: list) {
			System.out.println(v);
		}
		
		
	}

	

}
