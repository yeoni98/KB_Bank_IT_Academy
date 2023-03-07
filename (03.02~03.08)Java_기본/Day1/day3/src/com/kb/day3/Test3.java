package com.kb.day3;

public class Test3 {

	public static void main(String[] args) {
		//값을 한 번에 여러개 할당하기
		//m1 m2 m3... 이렇게 다 만들지 않고
		MyDate m = new MyDate();
		MyDate m1 = new MyDate(2023,3,6);
//		m1.year=2023;
//		m1.month =3;
//		m1.day = 6;
		System.out.println(m);
		System.out.println(m1);
		MyDate m2 = new MyDate(3,23);
		System.out.println(m2);

	}

}
