package com.edu.vo;

import com.edu.util.MyDate;

/*
 * Manager에 대한 정보를 저장하는 클래스
 * 1. private 필드 선언
 * 2. public 값이 주입되는 통로(생성자, setter())
 * 3. public 주입된 값을 반환하는 기능
 */
public class Manager extends Employee {
	private String dept;

	// 명시적 생성자
	//~test클래스에서 '생성자를 호출하는 시점'== 에 값이 필드에 주입
	public Manager(int empId, String name, MyDate birthdate, double salary, String dept) {
		//this => 필드초기화 == 새로운 값 할당
		//자식이 생성되려면, 상속 받으려면 => 무조건 부모 생성이 일어나야 됨
		//자식 생성자 첫 라인에 무조건 부모 가져오기
		super(empId, name, birthdate, salary); //부모에게서 받을 때
		this.dept = dept;
	}

	public String getDept() {
		return dept;
	}

	public void changeDept(String dept) {
		this.dept = dept;
	}
	//Employee의 toString()을 다시 정의
	@Override
	public String toString() {
//		return empId+","+name+","+birthdate.getDate()+","+salary+","+dept;
		return super.toString()+","+dept;
		
	}
//	@Override
//	public String getDetails() {
//		return super.getDetails()+","+dept;
//	}
	
	
}
