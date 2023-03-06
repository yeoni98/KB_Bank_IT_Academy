package com.itskb.ws01;

public class RandomUtilTest {

	public static void main(String[] args) {
		RandomUtil ru = new RandomUtil();
		int from = 20;
		int to = 60;
		

	
	    for (int i=0; i<100; i++) {
		    System.out.printf("%4d", ru.getRandomInt2(from, to));
		//클래스.static변수(new안하고 씀).
	}

	//Math라는 클래스에서 가져다 쓰는데

	}
}
