package spring.aop.solv;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/*
 * Target
 */

public class ProductService {
	
	//private Log log = LogFactory.getLog(getClass());
	
	public String deleteProduct(String id) {
		System.out.println(id+"deleteProduct..logic... 삭제 성공");
		return "삭제된 상품 ID :" + id;
	}

	
	
}
