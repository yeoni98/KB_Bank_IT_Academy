package com.edu.util;

public class MyDate {
	private int year, month, day;
	
	public MyDate(int year, int month, int day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}

	//non-String(year) + string(,) => String으로 convert됨. 주입된 값 리턴
//	public String getDate() {
//		return year+","+month+","+day; //year-month-day는 int타입인데 왜 string으로 return?
//		
//		
//	}
	@Override
	public String toString() {
		return year+"-"+month+"-"+day;
	}
}
