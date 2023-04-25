package spring.service.test;

import java.io.Reader;


import java.lang.reflect.Member;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import spring.service.domain.MemberVO;






/**
 * FileName : MyBATISTestApp.java
  * ㅇ JBDCTestApp.java 와 비교 이해.
  * ㅇ mybatis Framework 에서 제공하는 API을 사용 users table 의 정보 SELECT   
 */
public class MyBATISMemberTestApp {
	///Main method
	public static void main(String[] args) throws Exception{
		
		Reader reader=Resources.getResourceAsReader("config/SqlMapConfig.xml");		
		
		//==> 2. Reader 객체를 이용 xml metadata 에 설정된 각정 정보를 접근, 사용가능한 
		//==>    읽어들인 reader를 바탕으로 SqlSessionFactory를 리턴받는다.
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(reader);
		
		//==> 3.factory의 openSession()을 통해서 SqlSession을 리턴 받는다.
		SqlSession session=factory.openSession();
		
		/*
		 * 
		 * System.out.println("#####################################");
		 * System.out.println(":: 회원정보 출력");
		 * 
		 * for (MemberVO member : list) { System.out.println( member.toString() ) ; }
		 * System.out.println("#####################################");
		 */
		
		//==> Test 용 UserVO instance 생성
				MemberVO member = new MemberVO("user55","5555","sk","5555");
				
				//1.User03.addUser Test
				
		
		/*
		 * Object obj = session.insert("MemberMapper.registerMember", member);
		 * session.commit(); //이 부분 반드시 해줘야 한다....mvc에서는 생략가능. //iBatis와 다르게 insert문의
		 * //리턴타입은 insert된 row수를 // 반환한다.
		 * System.out.println(":: 1. registerMember(INSERT)  result ? "+obj); //1
		 * System.out.println("\n");
		 */
		 
				 /*
				  
				  //2. deleteMember
				  int deleteResult = session.delete("MemberMapper.deleteMember", member.getId());
					session.commit(); //이 부분 반드시 해줘야 한다.
					System.out.println(":: 2. deleteUser(DELETE) result ? "+deleteResult);
					System.out.println("\n");
		*/			
				
		/*
		 * //3. updateMember member.setName("장보고"); int updateResult =
		 * session.update("MemberMapper.updateMember", member); session.commit(); //이부분
		 * 반드시 해줘야 한다.
		 * System.out.println(":: 3. updateMember(UPDATE) result ? "+updateResult);//1
		 * System.out.println("\n");
		 */
				
				
	//4. showAllMember
				
		/*
		 * List<MemberVO> list=session.selectList("MemberMapper.showAllMember");
		 * System.out.println("#####################################");
		 * System.out.println(":: 회원정보 출력");
		 * 
		 * for (MemberVO m : list) { System.out.println( m.toString() ) ; }
		 */
				
	//5. getMember
		
		/*
		 * MemberVO member = (MemberVO)session.selectOne("MemberMapper.getMember",
		 * "user11"); System.out.println(":: 1. get(SELECT)  ? "+member.toString());
		 * System.out.println("\n");
		 */
		
		//6. isExist
		
		System.out.println("::idExist");
		MemberVO m = (MemberVO)session.selectOne("MemberMapper.getMember","user11");
		if(m!=null) {
			System.out.println("이미 존재하는 회원입니다");
		}else {
			System.out.println("존재하지 않는 회원입니다.");
		}
		
		//7. login
		System.out.println("::login");
		m.setId("user00");
		m.setPassword("2414");
		String name = (String)session.selectOne("MemberMapper.login", m);
		
		System.out.println(":: 2. get(SELECT)  ? "+name);  
		 
		
		
	}// end of main



	

	

	

	
}//end of class

/*
 * ■ MyBATISTestApp / JDBCTestApp 를 통한 MyBATIS Framework 의 이해
 * ㅇ SQL,커넥션,트랜잭선 를 메타데이타 캡술화였으며, 
 *     :: 참조 => SqlMapConfig.xml / mybatis-userservice-mapping.xml
 * ㅇ JDBC철차 :  Connection => Statement => ResultSet
 *      resource 관리 : close
 *      query 수행 결과 비지니스객체(VO) 바인딩 JDBC API 를 사용하여 수행시 반복적으로 반드시
 *      수행하는 일련의 과정을 수행함.
 *      :: 참조 =>List<User> list = session.selectList("User.getUserList");
 *  
 *  ■ MyBATIS Framework 의 장점
 *  ㅇ 작고 간단하다 ( mybatis-3.2.8.jar / 약 400kb / 다른 라이브러리와 의존관계 없다. )
 *  ㅇ 기존 애플리케이션/테이터베이스 변경 불필요 
 *      (SQL Mapper(Data Mapper) =>SQL 과 비지니스 객체와의 바인딩)
 *  ㅇ 생산성 / 성능 / 작업의 분배 (소스코드와 SQL 의 분리)
 *  ㅇ 관심사의 분리 
 *       ( DBMS 에 독립적인 API제공 및 JDBC API가 아닌 비지니스 객체만 가지고 작업가능)
 *        
  *  ■ MyBATIS Framework 은 JDBC 절차를 간결화한 lib 이다
  *     ( JDBC를 절차 은익한 lib)        
*/
