package com.edu.test;

import com.edu.util.MyDate;
import com.edu.vo.Engineer;
import com.edu.vo.Manager;
import com.edu.vo.Secretary;

/*
 * 1.객체 생성 == 클래스 멤버 메모리에 올린당.
 * 
 * 2. 접근 == 호출
 *  1) field에 접근하는 방법 => 값 할당
 *  2) 메소드 접근 => 호출
 *  
 */
public class EmployeeAppTest1 {
	public static void main(String[] args) {
		Manager m1 = new Manager(); // 기본 생성자 호출 => 값을 바로 주입하지 않는다는 의미일 뿐. 일단 객체 생성
		m1.setManagerField("Gosling", new MyDate(2000,1,10), 30000.0, "Maketing"); // => 그 다음 주입
		Manager m = new Manager("James", new MyDate(1990,3,24),20000.0,"IT"); //명시적 호출 => 객체 생성 시점에 값을 주입.
////		System.out.println(m);
////		System.out.println(m2);
//		// m.name = "Gosling";
		System.out.println(m1.getDetails());
//		System.out.println(m2.getDetails());
//		
		Engineer eg = new Engineer("EEE", new MyDate(1990,3,24), 34000.0, "JAVA", 200);
		Secretary s = new Secretary("SSS", new MyDate(1985,11,2),40000.0, "James");
		System.out.println("=====정보를 출력=====");
		System.out.println(m.getDetails());
		System.out.println(eg.getDetails());
		System.out.println(s.getDetails());
		
		System.out.println("=====연봉 정보 출력=====");
		
		System.out.println("Manager 연봉: "+m.getSalary()*12);
		System.out.println("Engineer 연봉: "+eg.getSalary()*12+eg.getBonus());
		System.out.println("Secretary 연봉: "+ s.getSalary()*12+"달러");
		
		System.out.println(" =====각 직원의 이름 출력=====");
		System.out.println("Manager 이름: "+ m.getName());
		System.out.println("Engineer 이름: "+ eg.getName());
		System.out.println("Secretary 이름: "+ s.getName());
		/*
		 * 1. eg라는 이름으로 Engineer를 생성
		 * 2. s라는 이름으로 secretary 생성
		 * 3. Manager, Engineer, Secretary정보를 콘솔로 출력
		 * 4. Manager, Engineer, Secretary의 연봉을 출력
		 * 5. Manager, Engineer, Secretary의 이름을 각각 출력
		 */

	}

}
