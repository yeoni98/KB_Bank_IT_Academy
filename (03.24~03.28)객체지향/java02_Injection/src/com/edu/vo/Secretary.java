package com.edu.vo;

import com.edu.util.MyDate;

/*
 * Manager에 대한 정보를 저장하는 클래스
 * 1. private 필드 선언
 * 2. public 값이 주입되는 통로(생성자, setter())
 * 3. public 주입된 값을 반환하는 기능
 */
public class Secretary {
	//field.. 변수 중에서도 jvm중 heap에 들어감(객체의 구성요소)
	private String name;
	private MyDate birthdate;
 	private double salary;
	private String bossOfName;
	
	public Secretary() {}; // 기본 생성자;
	
	// 명시적 생성자
	//~test클래스에서 '생성자를 호출하는 시점'== 에 값이 필드에 주입
	public Secretary(String name, MyDate birthdate,double salary, String bossOfName) {
		//this => 필드초기화 == 새로운 값 할당
		super();
		this.name = name;
		this.birthdate = birthdate;
		this.salary = salary;
		this.bossOfName = bossOfName;
	}
	//값을 주입하는 통로
	public void setManagerField(String name, MyDate birthdate,double salary, String bossOfName) {
		
	}
	public String getDetails() { //getDate()
		return name +","+birthdate.getDate()+","+salary+","+bossOfName;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MyDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(MyDate birthdate) {
		this.birthdate = birthdate;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getBossOfName() {
		return bossOfName;
	}

	public void setBossOfName(String bossOfName) {
		this.bossOfName = bossOfName;
	}
	
	
}
