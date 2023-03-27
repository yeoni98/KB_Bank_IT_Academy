package com.edu.greet.test;

import com.edu.greet.Greeting;

public class GreetingAppTest {

	public static void main(String[] args) {
		/*
		 * test 클래스가 하는 일
		 * 1.클래스 객체를 생성 == 클래스의 멤버를 메모리에 올린다.
		 * 2.접근
		 *   접근할 수 있는 대상
		 *   1) 필드에 접근 -> 값 할당
		 *   2) 메소드에 접근 -> 호출
		 * 3.
		 */
		Greeting g = new Greeting();
		//새로운 객체 생성
		g.target = "1반 여러분";
		g.message = "반갑습니다.";
		System.out.println(g.sayHello());
		
		}

}
