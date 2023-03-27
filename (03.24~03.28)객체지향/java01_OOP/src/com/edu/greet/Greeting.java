package com.edu.greet;

/*
 * 특정한 [대상]에게
 * 다양한 [인사말]을 출력하는 정보를 가지는 클래스
 * 변수 2개 필요
 * OOP 에서의 Object class 구현 한 것
 * 하지만 프로그램이 되려면 target과 message에 접근하는 컨테이너 만들어야 함 => ex)사람에 대한 건 사람class, 메세지class~~
 */

public class Greeting {
	//필드..클래스 바로 밑에 선언되어야 함..메소드 블락 바깥에 선언
	public String target;
	public String message;

	
	//기능을 정의
	public String sayHello(){
		return target + " , "+message+"~~~!!";
		

	}

}
