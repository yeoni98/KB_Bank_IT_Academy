package com.kb.sms;

import java.util.Random;
import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		Random r = new Random();
		Scanner s = new Scanner(System.in);
		System.out.println("복권을 살 금액을 입력하세요");
		int money = s.nextInt();
		int count = money/1000;
		
		for(int c=1; c<=count; c++) {
			for(int i=0; i<6; i++) {
				int result = r.nextInt(45)+1; //1~45까지 나온다.
				System.out.print(result+" ");
				
				
			}
			System.out.println();
	
		
		
		}
		
		

	}

}
// nextInt() vs nextInt(정수(4)=> 0 포함하고 4는 포함하지 않는다.

//중복되지 않게 하는 것