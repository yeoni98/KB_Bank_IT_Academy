package com.kb.sms;

import java.util.Random;

public class Test5 {

	public static void main(String[] args) {
		//클래스 가져다 쓰는 법
		//사용 1 - new로 쓰기. 이게 정석임
		Random r = new Random();
		int num = r.nextInt();
		System.out.println(num);
		//사용 2 예외 - static 메서드일 경우 class명.class() 로 한다. new 안한다.
		int a = Math.abs(-34);
		System.out.println(a);
		System.out.println(Math.random()); //0~1 사이값(0은 포함 1은 불포함 하는 사이값)
		String b = "123";
		int bb=Integer.parseInt(b);//Integar = 정수의 객체형을 만들어줌, parseInt = 문자를 숫자(정수)로 바꿔주는 역할
		bb++;
		System.out.println(bb);
		

	}

}
