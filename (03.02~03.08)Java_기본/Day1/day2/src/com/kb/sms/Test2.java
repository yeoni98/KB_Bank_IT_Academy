package com.kb.sms;

import java.util.Random;

public class Test2 {

	public static void main(String[] args) {
		Random r = new Random();
		
		for(int i=0; i<6; i++) {
			int result = r.nextInt(45)+1; //1~45까지 나온다.
			System.out.print(result+" ");
			
		}
		

	}

}
// nextInt() vs nextInt(정수(4)=> 0 포함하고 4는 포함하지 않는다.