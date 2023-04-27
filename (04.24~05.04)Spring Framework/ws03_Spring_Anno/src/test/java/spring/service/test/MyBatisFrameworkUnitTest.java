package spring.service.test;

import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import spring.service.domain.MemberVO;
import spring.service.user.MemberDAO;
import spring.service.user.MemberService;

public class MyBatisFrameworkUnitTest {

	public static void main(String[] args) throws Exception{
		ApplicationContext context =
				new ClassPathXmlApplicationContext(
								new String[] {	"/beans/userservice.xml"	 }
	);
	//==> IoC Container 로 부터 획득한 UserDAO 인스턴스 획득
		MemberService memberService = (MemberService)context.getBean("memberServiceImpl");
		
		//1.
		MemberDAO memberDAO = (MemberDAO)context.getBean("memberDAOImpl");
		MemberVO vo = new MemberVO("7777", "123", "아이유", "여의도");
		System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
		//1.UserService.addUser(user) Test
		/*System.out.println(":: 1. add(INSERT)  ? ");
		memberDAO.registerMember(vo);
		
		System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
		*/
		//2.
		//MemberVO vo = new MemberVO("7777", "123", "아이유", "여의도");
	
		
		/*
		vo.setName("아이유2");
		System.out.println(":: 2. update(UPDATE)  ? ");
		memberDAO.updateMember(vo);
		*/
		//3.

		//4.
		/*MemberVO vo=session.selectOne("MemberMapper.getMember","1111");
		System.out.println(vo);
		
		System.out.println("==================="); */
		vo = memberService.getMember("7777");
		System.out.println(":: 2. get(SELECT)  ? "+vo);
		
		//5
		System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
		//6.UserService.getUserList() Test
		System.out.println(":: 6. all User(SELECT)  ? ");
		List<MemberVO> list = memberService.showAllMember(new MemberVO());
		for (int i =0 ;  i < list.size() ; i++) {
			System.out.print( "<"+ ( i +1 )+"> 번째 회원 정보... ");
			System.out.println( list.get(i).toString() );
		}
		System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
			
		String id = memberService.idExist("7777");
		System.out.println("ok"+id);
		
	}

}










