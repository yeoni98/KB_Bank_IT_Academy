package com.kb.day3;

public class Test {

	public static void main(String[] args) {
		MyDate m = new MyDate();
		m.year = 2023;
		m.month = 3;
		m.day = 6;
		
//		String s = m.toString();
//		System.out.println(s);
//		System.out.println(m.toString()); 이렇게 한 줄로 나타낼 수 있음
		System.out.println(m); //m.toString()호출 한다.
		//이렇게 한 줄로 나타낼 수 있음. 이게 더 간편하고 잘 쓰임
		
		

	}

}
