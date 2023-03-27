package com.edu.vo;

import com.edu.util.MyDate;

//부모 클래스, Super class, Parent Class

public class Employee {
	//직원 구분하기 위한 필드 추가
	private int empId;
	private String name;
	private MyDate birthdate;
 	private double salary;
 	
 	//상수값
 	public static final double BASIC_SALARY = 100;
 	
 	
 	public Employee() {}
 	public Employee(int empId,String name, MyDate birthdate, double salary) {
 		//필드 초기화
 		super();
 		this.empId = empId;
 		this.name = name;
 		this.birthdate = birthdate;
 		this.salary = salary;
 		
	}
 	
 	/*
 	 * this
 	 * 1)local v와 field의 이름이 동일할 때 구분하기 위해서 필드 앞에 붙인다.
 	 * 2)this() -> 하나의 클래스에서 또다른 생성자를 호출할 때 사용함.
 	 */
 	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
	public Employee(int empId,String name, MyDate birthdate) { // 생성자 오버로딩
		this(empId, name, birthdate,BASIC_SALARY);
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
	public void changeSalary(double salary) {
		this.salary = salary; //set 보단 기존에 salary 입력값을 바꿔주니까 change로
	}
	
	// Object class의 toString()을 다시 정의
	//클래스의 필드를 리턴하는 기능을 새롭게 정의할 필요 없이 toString() 기능을 재정의(오버라이딩)해서 사용하자
	@Override
	public String toString() {
		return empId+","+name+","+birthdate+","+salary; //toString()이라는 참조 변수가 항상 생략되어 있어서 birthdte.toString() 안해도 됨
	}
//	public String getDetails() {
//		return name+","+birthdate.getDate()+","+salary;
//	} //



}
