package spring.aop.anno;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/*
 * Core Concern만으로 작성된 클래스... Target
 */

public class MemberService {
	
	//private Log log = LogFactory.getLog(getClass());
	
	public void register(String id) {
		System.out.println("register...logic...회원등록 성공");
	
	}
	public void findMember(String id) {
		System.out.println("findMember... logic.. 회원 검색 성공");
		
	}
	
	
}
