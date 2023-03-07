package com.kb.day3;

public class Test5 {

	public static void main(String[] args) {
		//객체 배열
		int [] su = new int[5]; // 정수 타입
		su[1] = 30;
		MyDate[] md = new MyDate[5]; //레퍼런스 타입
		md[0] = new MyDate(3,23);
		md[1] = new MyDate(4,21);
		md[2] = new MyDate(5,5);
		md[3] = new MyDate(5,15);
		md[4] = new MyDate(5,29);
		
		MyDate m = md[2];
		System.out.println(m);
		System.out.println(md[1]); //md[1].toString() 부르는 것
		
		for(MyDate mm: md)//md 한개씩 전달 돼서. 모두 다 출력할 때 이게 더 효율적임
		{
			System.out.println(mm); // mm.toString()
		}
		for(int i=0; i<md.length; i++) { // 부분적으로 출력할 때
			
			System.out.println(md[i]);
		}
		for(MyDate mm: md) {
			if(mm.month == 5)
				System.out.println(mm);

	}
	}
}
