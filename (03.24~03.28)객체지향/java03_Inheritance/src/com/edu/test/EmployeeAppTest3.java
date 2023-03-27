package com.edu.test;

import com.edu.util.MyDate;
import com.edu.vo.Employee;
import com.edu.vo.Engineer;
import com.edu.vo.Manager;
import com.edu.vo.Secretary;

/*
 * Employee 타입의 배열을 생성
 * 이 안에 여러 명의 Manager, Engineer, Secretary객체를 넣고
 * 부모타입으로 단일하게 이기종간의 객체들을 핸들링할 수 있는 코드를 작성
 *  
 * Heterogeneous Collection(상속덕분)
 * 문제
 * 1. 
 */
public class EmployeeAppTest3 {
	public static void main(String[] args) {
		Employee[ ] emps = {
				new Manager("James", new MyDate(1990,3,24),200002.0, "IT"),
				new Engineer("Gosling", new MyDate(1990,2,1), 38283.0, "Marketing",100),
				new Manager("sydl", new MyDate(1777,1,22),20000.0, "Research"),
				new Secretary("dssds", new MyDate(1287,1,22),20000.0, "goslin"),
				new Manager("jinny", new MyDate(1822,7,23), 274992, "IT")
		};
		System.out.println("=====정보 출력=====");
		
		for(Employee e :emps) {
			System.out.println(e.getDetails());
		}
		System.out.println("=====연봉=====");
		
		for(Employee e :emps) {
		
			if(e instanceof Engineer) { // Employee타입으로 생성된 객체가 Engineer라면
				Engineer eg = (Engineer)e;
				System.out.println(e.getName()+" 님의 연봉은 "+e.getSalary()*12+eg.getBonus()+" 달러입니다.");
				
			}
			else {// Employee타입으로 생성된 객체가 Engineer라면
				
				System.out.println(e.getName()+" 님의 연봉은 "+e.getSalary()*12+" 달러입니다.");
			}
//			if(e instanceof Secretary) {// Employee타입으로 생성된 객체가 Secretary라면
//			}
		}
		System.out.println("===이름===");
		for(Employee e :emps) System.out.println("이름: "+e.getName());
	}
}
		/*
		 * 1. eg라는 이름으로 Engineer를 생성
		 * 2. s라는 이름으로 secretary 생성
		 * 3. Manager, Engineer, Secretary정보를 콘솔로 출력
		 * 4. Manager, Engineer, Secretary의 연봉을 출력
		 * 5. Manager, Engineer, Secretary의 이름을 각각 출력
		 */
//		System.out.println();
//		Manager m1 = new Manager(); //두가지 방법 있음. 1-1.기본 생성자 호출 => 값을 바로 주입하지 않는다는 의미일 뿐. 일단 객체 생성
//		m1.setManagerField("Gosling", new MyDate(2000,1,10), 30000.0, "Maketing"); // => 1-2.그 다음 주입
//		Manager m = new Manager("James", new MyDate(1990,3,24),20000.0,"IT"); //2.명시적 호출 => 객체 생성 시점에 값을 주입.
//////		System.out.println(m);
//////		System.out.println(m2);
////		// m.name = "Gosling";
//		System.out.println(m1.getDetails());
////		System.out.println(m2.getDetails());
////		
//		Engineer eg = new Engineer("EEE", new MyDate(1990,3,24), 34000.0, "JAVA", 200);
//		Secretary s = new Secretary("SSS", new MyDate(1985,11,2),40000.0, "James");
//		System.out.println("=====정보를 출력=====");
//		System.out.println(m.getDetails());
//		System.out.println(eg.getDetails());
//		System.out.println(s.getDetails());
//		
//		System.out.println("=====연봉 정보 출력=====");
//		
//		System.out.println("Manager 연봉: "+m.getSalary()*12);
//		System.out.println("Engineer 연봉: "+eg.getSalary()*12+eg.getBonus());
//		System.out.println("Secretary 연봉: "+ s.getSalary()*12+"달러");
//		
//		System.out.println(" =====각 직원의 이름 출력=====");
//		System.out.println("Manager 이름: "+ m.getName());
//		System.out.println("Engineer 이름: "+ eg.getName());
//		System.out.println("Secretary 이름: "+ s.getName());
//
//	}
//
//}
