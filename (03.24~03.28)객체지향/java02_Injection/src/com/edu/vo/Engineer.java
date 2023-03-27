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
public class Engineer {
	private String name;
	private MyDate birthdate;
	private double salary;
	private String tech;
	private double bonus;
	
	
	public Engineer(String name, MyDate birthdate, double salary, String tech, double bonus) {
		super();
		this.name = name;
		this.birthdate = birthdate;
		this.salary = salary;
		this.tech = tech;
		this.bonus = bonus;
	}


	public String getDetails() {
		return name+","+birthdate.getDate()+","+salary+","+tech+","+bonus;
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


	public String getTech() {
		return tech;
	}


	public void setTech(String tech) {
		this.tech = tech;
	}


	public double getBonus() {
		return bonus;
	}


	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
	
}
