package com.edu.service;

import com.edu.vo.Employee;
import com.edu.vo.Engineer;
import com.edu.vo.Manager;

/*
 * 기능들만 정의된 Service클래스
 * 
 * 안 되는 경우
 * 
   1. 상속 기술 사용 안 했을 경우
   Manager           Engineer         Secretary
   
   step1. 가장 저차원적인 기능 정의
   >> 추가에 관련된 기능을 정의
   public void addManager(Manager m){}
   public void insertEngine(Engineer eg){}
   public void plusSecretaryMember(Secretary s){}
   =>가동력 떨어짐
   
   step2. 이것도 저차원 
   public void addManager(Manager m){}
   public void addEngine(Engineer eg){}
   public void addSecretaryMember(Secretary s){}
   
   2. 상속 기술 사용한 경우
                  Employee(다양한 이기종간의 자식 클래스들을 단일하게 관리)   => Method Overloading: 하는 일은 같지만, 처리하는 데이터를 달리할 때 사용
                                                                     1. Method 이름은 같아야 함
                                                                     2. Method 인자값은 다르다
                                                                     3. 리턴 타입은 상관없다.
                  
   Manager           Engineer         Secretary
   
   step3.
   public void addEmployee(Manager m){}
   public void addEmployee(Engineer eg){}
   public void addEmployee(Secretary s){}
   
   step4. Employee e로 모든 자식들을 받는다.. Polymorphic Argument : 인자값도 상속
   public void addEmployee(Employee e){}
      if(e instanceof Manager){
      }if(e instanceof Engineer){
      }if(e instanceof Secretary){
      }
   
 */
public class EmployeeService {
	/*
	 * 1. 모든 직원의 정보를 출력하는 기능을 정의
	 * 모든 -> All or -s
*/
	public void printAllEmployee(Employee[]ea) {
		for(Employee e: ea) System.out.println(e);
	}
	/*
	 * 2. 모든 직원 중 특정한 직원을 검색하는 기능을 정의
	 * find~, search~
	 * 리턴 타입이 void가 아니면 선언 부터 한다 
	 */
	public Employee findEmployee(Employee[] ea, int empId) {
		//리턴 타입이 void가 아니면 선언 부터 한다
		Employee employee = null;
		for(Employee e: ea) {
			if(e.getEmpId()==empId) { //empId는 unique한 값
				employee = e;
				break;
				
			}
		}
		return employee;
	}
	 /* 3. 모든 직원 중 동일한 부서에서 근무하는 지원을 리턴
	  * 
	 */ 	
	public Employee[] findEmployee(Employee[] ea, String dept) {
//		리턴타입이 컨테이너일 때 생성하고
		Employee[] temp = new Employee[ea.length ];
		int idx = 0;
		for(Employee e: ea) {
			if(e instanceof Manager) {
				if(((Manager) e).getDept().equals(dept)) {
					temp[idx++] = e;
				}
			}
		}
		return temp;
		}
	 /* 4. 특정한 직원의 연봉을 리턴하는 기능을 정의
	  * 
	 */ 
	public int getAnnualSalary(Employee e) {
		int annualSalary = 0;
		annualSalary = (int)(e.getSalary()*12);
		if(e instanceof Engineer)
			annualSalary = (int)(e.getSalary()*12+((Engineer) e).getBonus());
		return annualSalary;
	}
	 /* 5. 모든 직원의 연간 총 인건비를 리턴하는 기능을 정의 =>합?
	 */
	public int getTotalCost(Employee[] ea) {
		int totalCost = 0;
		for(Employee e: ea)
			totalCost += getAnnualSalary(e);
		return totalCost;	
	}

}
