package com.kb.sms;

import java.util.Random;
import java.util.Scanner;

public class Test4 {
	static Random r = new Random();
	// r이 getNumber()에 있거나 main에 있어야 되는데 없어서 test4클래스에 넣어줌 random r
	public static void main(String... args) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("복권을 살 금액을 입력하세요");
		int money = s.nextInt();
		int count = money/1000;
		
		for(int c=1; c<=count; c++) {
			getNumber();	
		
		}
		
		

	}//end main()
	public static void getNumber() { //임의의 숫자 6개 출력
		for(int i=0; i<6; i++) {
				int result = r.nextInt(45)+1; //1~45까지 나온다.
				System.out.print(result+" ");
				
				
			}
			System.out.println();
	
	}

}
// nextInt() vs nextInt(정수(4)=> 0 포함하고 4는 포함하지 않는다.

//중복되지 않게 하는 것