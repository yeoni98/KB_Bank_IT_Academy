package com.edu.vo;

import com.edu.util.MyDate;

/*
 * 클래스 만들 때
 * 1. private field 선언
 * 2. 값이 주입되는 통로를 만든다
 *    public 명시적 생성자
 *    public void setter()
 * 3. 주입된 값을 반환하는 기능을 정의
 * 
 * name, birthdate, salary, mainSkill, bonus --> 5
 * getDetail()
 */
public class Engineer extends Employee {
	private String tech;
	private double bonus;
	
	/*
	 * 자식 생성자 첫 라인에서
	 * 부모 생성자 호출이 무조건 일어난다.
	 * super();
	 * super(o,o,o);
	 * 
	 */
	public Engineer() {
		super(); //Employee 기본생성자 호출
	}//기본 생성자
	
	public Engineer(int empId, String name, MyDate birthdate, double salary, String tech, double bonus) {
		super(empId,name,birthdate,salary);
		this.tech = tech;
		this.bonus = bonus;
	}

	public String getTech() {
		return tech;
	}
	public void changeTech(String tech) {
		this.tech = tech;
	}
	public double getBonus() {
		return bonus;
	}
	public void changeBonus(double bonus) {
		this.bonus = bonus;
	}
	
//	@Override
//	public String getDetails() {
//		return super.getDetails()+","+tech+","+bonus;
//	}
	
	@Override
	public String toString() {
		return super.toString()+","+tech+","+bonus;
		
	}
	
	
}
