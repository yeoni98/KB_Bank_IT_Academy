package com.kb.day3;

public class MyDate {
	public int year; //누구나 사용 가능
	int month; // 같은 패키지 내에서 사용 가능
	int day;
	//생성자(Constructor): 클래스와 이름이 같고, 리턴타입이 없어야 함.
	//기본생성자( Default constructor)
	//: 파라메터가 없고 바디가 없는 생성자
	//: 클래스에 생성자가 하나도 없다면 컴파일러가 기본으로 만들어줌.
	
	public MyDate() {} // MyDate m = new MyDate()를 자동 생성해줌
	public MyDate(int year, int month, int d) {
		this.year = year; // 로컬에 없으면 this 따라 가서 찾아본다.
		this.month = month;
		day = d;
		//this. 언제 적냐 왜 적어 굳이? 나한테도 month 가 있는데 this에도 month 가 있을때, this로 가게 하기 위해서
		// 멤버 변수 == 로컬변수 일때 this 쓴다.
		
	
	}
	public MyDate(int m, int d) {
		year = 2023;
		month = m;
		day = d;
	}
	public String toString() //string으로 만들어줄게 // 
	{
		return year+"년 "+month+"월 "+day+"일 ";
	}
	

}
