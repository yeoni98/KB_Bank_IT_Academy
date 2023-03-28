package com.self.test;

import com.self.service.EmployeeService;
import com.self.util.MyDate;
import com.self.vo.Employee;
import com.self.vo.Engineer;
import com.self.vo.Manager;

public class EmployeeServiceTest {
	public static void main(String[] args) {
		//1. Service 객체를 생성
		EmployeeService service = new EmployeeService(20);
		
		//2. method를 각각 호출..
		System.out.println("============ 1. addManager ============ ");
		service.addEmployeeService(new Manager("AAA", new MyDate(1978, 1, 1), 20000.0, "개발부", 10));
		service.addEmployeeService(new Manager("BBB", new MyDate(1975, 2, 1), 34000.0, "기획부", 20));
		service.addEmployeeService(new Manager("CCC", new MyDate(1980, 3, 3), 20000.0, "교육부", 30));
		service.addEmployeeService(new Manager("DDD", new MyDate(1995, 8, 1), 37000.0, "개발부", 10));
		
		System.out.println("============ Manager 정보확인 ============ ");
		service.printEmployees("m");
	
		System.out.println("\n============ 1. addEngineer ============ ");
		service.addEmployeeService(new Engineer("EEE", new MyDate(1995,3,4), 350000.0, "Java", 200.0));
		service.addEmployeeService(new Engineer("FFF", new MyDate(1995,7,2), 350000.0, "Java", 200.0));
		service.addEmployeeService(new Engineer("GGG", new MyDate(1994,11,2), 450000.0, "Python", 300.0));
		
		System.out.println("============ Engineer 정보확인 ============ ");
		service.printEmployees("e");
		
		System.out.println("\n============ 2. deleteManager(AAA 삭제) ============ ");
		service.deleteEmployee("AAA");
		System.out.println("============ Manager 정보확인 ============ ");
		service.printEmployees("m");
		
		System.out.println("\n============ 3. updateManager(CCC 연봉 수정 200->350) ============ ");
		service.updateEmployee("교육부", 30,  "CCC");//?
		System.out.println("============ Manager 정보확인 ============ ");
		service.printEmployees("m");
		
		System.out.println("\n============ 4. findManager(BBB) ============ ");
		System.out.println(service.findEmployee("BBB"));
		
		System.out.println("\n============ 5. findManager(10) ============ ");
		System.out.println("10번 부서에 근무하는 직원들 입니다..");
		Employee[ ] retMs1 = service.findEmployee(10);
		for(Employee e : retMs1) {
			if(e==null) continue;
			System.out.println(e);
		System.out.println("\n============ 6. getAnnualSalary(e) ============ ");
		System.out.println(service.getAnnualSalary(e));
		System.out.println("\n============ 7. getTotalCost(e) ============ ");
		System.out.println(service.getTotalCost());
	}
}
}







