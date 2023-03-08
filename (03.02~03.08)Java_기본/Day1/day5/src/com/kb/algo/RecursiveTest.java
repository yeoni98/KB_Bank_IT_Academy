package com.kb.algo;
//1~10까지 출력해보자
public class RecursiveTest {

	public static void main(String[] args) {
		recursive(1);
		

	}
	public static void recursive(int su) {
		if(su>10) return;
		System.out.println(su);
		recursive(++su);
	}

}
