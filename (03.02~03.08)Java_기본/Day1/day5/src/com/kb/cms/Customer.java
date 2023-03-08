package com.kb.cms;

public class Customer extends Object implements Comparable<Customer>{
	int num;
	String name;
	String address;
	public Customer() {  // source - using field delete all
		//super(); // 안 넣으면 컴파일러가 자동 삽입
	}
	public Customer(int num, String name, String address) {//select all
		super(); //super의 생성자 호츌
		this.num = num;
		this.name = name;
		this.address = address;
	}
	@Override
	public String toString() { // toString()에서 그냥 스트링보단 편집 많이 해야 되니 StringBuilder 쓰자(권장)
		StringBuilder builder = new StringBuilder();
		builder.append("Customer [num=");
		builder.append(num);
		builder.append(", name=");
		builder.append(name);
		builder.append(", address=");
		builder.append(address);
		builder.append("]");
		return builder.toString();
	}
	@Override
	public int compareTo(Customer o) { // Comparable의 메소드는 compareTo야
//		//고객 번호로 sort
//		int result = this.num - o.num;
//			//파라메터로 온 num 값을 빼라
//	    return result;
//	    //고객 이름으로 sort 하고 싶으면
	    return this.name.compareTo(o.name); 
	    //int는 빼기 되는데 문자열 String의 경우 덧셈밖에 안 되니, compareTo를 이용해서 비교해서 뭐가 더 큰지 알려준다.
	}
	


}
