package spring.aop.solv;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;


@Aspect 
public class LoggingAdvice {

	private Log log = LogFactory.getLog(getClass());
	
	//포인트 컷 스펙을 여기다가 적는다 anno.xml이 아니라
	//target 메소드 리턴타입이 String이고 spring 패키지 아래에 있는 모든 패키지 중에서
	//Product로 시작하는 클래스의 delete로 시작하는 메소드(인자값 1개 이상)에 JoinPoint delete*(..): 메소드 Product* : 클래스
	@Around("execution(public String spring..Product*.delete*(..)")
	//weaving 되어야 하기 때문에
	public void logPush(ProceedingJoinPoint pjp) throws Throwable{
		log.info("\ncheck...before logging...");
		
		Object ret = pjp.proceed(); // 호출 되는 지점이 target으로 위빙 되는 시점..
		System.out.println("target method return.."+ret);
		// register(); 를 호출 할 때 pjp.proceed()가 호출 됨(==target이 호출되는 시점) ==> weaving ==> null이 리턴 됨.
		log.info("check...before logging...");
		
	}
	
}
