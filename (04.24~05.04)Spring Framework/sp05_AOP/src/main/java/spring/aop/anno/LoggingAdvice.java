package spring.aop.anno;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAdvice {

	private Log log = LogFactory.getLog(getClass());
	
	//weaving 되어야 하기 때문에
	public void logPush(ProceedingJoinPoint pjp) throws Throwable{
		log.info("\ncheck...before logging...");
		
		Object ret = pjp.proceed(); // 호출 되는 지점이 target으로 위빙 되는 시점..
		System.out.println("target method return.."+ret);
		// register(); 를 호출 할 때 pjp.proceed()가 호출 됨(==target이 호출되는 시점) ==> weaving ==> null이 리턴 됨.
		log.info("check...before logging...");
		
	}
}
