package com.edu.access.test;

import com.edu.access.parent.Parent;
class Child extends Parent{
	public void test() {
		//publicVar는 서로다른 클래스, 다른 패키지라도 접근 허용
		System.out.println(publicVar);
		//protectedVar는 Child, Parent 가 상속관계... public하고 동일한 효과
		System.out.println(protectedVar);
		//같은 패키지에 있어야만 접근 가능하다. access.parent가 아니라 access.test에 있어서 불가 public이 아니라서
//		System.out.println(var);
		//not visible => parent에 있긴 한데 접근이 안 된다.
		
		//같은 클래스 안에서만 접근을 허용함
//		System.out.println(privateVar);
	}
}

public class AccessAppTest {

	public static void main(String[] args) {
		

	}

}
