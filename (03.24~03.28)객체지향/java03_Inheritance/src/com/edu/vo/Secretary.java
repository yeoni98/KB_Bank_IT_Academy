package com.edu.vo;

import com.edu.util.MyDate;

/*
 * Manager에 대한 정보를 저장하는 클래스
 * 1. private 필드 선언
 * 2. public 값이 주입되는 통로(생성자, setter())
 * 3. public 주입된 값을 반환하는 기능
 */
public class Secretary extends Employee{
	private String bossOfName;
	
	public Secretary() {
		super();
	}	
	// 명시적 생성자
	//~test클래스에서 '생성자를 호출하는 시점'== 에 값이 필드에 주입
	public Secretary(String name, MyDate birthdate,double salary, String bossOfName) {
		//this => 필드초기화 == 새로운 값 할당
		super(name, birthdate,salary);
		this.bossOfName = bossOfName;
	}

	public String getBossOfName() {
		return bossOfName;
	}

	public void changeBossOfName(String bossOfName) {
		this.bossOfName = bossOfName;
	}
	@Override
	public String getDetails() {
		return super.getDetails()+","+bossOfName;
	}

	
}
