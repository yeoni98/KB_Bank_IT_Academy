package com.self.vo;

import com.self.util.MyDate;

public class Employee {
	 	private double salary;
	 	private String name;
	 	private MyDate birthDate;
	 	
	 	//상수값
	 	public static final double BASIC_SALARY = 100;
	 	
	 	
	 	public Employee() {}
	 	public Employee(String name, double salary, MyDate birthDate) {
	 		//필드 초기화
	 		super();
	 		this.name = name;
	 		this.salary = salary;
	 		this.birthDate = birthDate;
	 		
		}
		public double getSalary() {
			return salary;
		}
		public void setSalary(double salary) {
			this.salary = salary;
		}
		public Employee(String name, MyDate birthDate) { // 생성자 오버로딩
			this(name,BASIC_SALARY, birthDate);
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public MyDate getBirthDate() {
			return birthDate;
		}
		public void setBirthDate(MyDate birthDate) {
			this.birthDate = birthDate;
		}
		public static double getBasicSalary() {
			return BASIC_SALARY;
		}
		@Override
		public String toString() {
			return name+","+salary+","+birthDate; //toString()이라는 참조 변수가 항상 생략되어 있어서 birthdte.toString() 안해도 됨
	 	

	}
}


