package com.self.service;

import com.self.service.EmployeeService;
import com.self.vo.Employee;
import com.self.vo.Engineer;
import com.self.vo.Manager;
//add, delete, find, update,print
public class EmployeeService {
	//1. 
	Employee[] emps;
	int idx = 0;
	
	private static EmployeeService service = new EmployeeService(20);
	
		//2.
		public EmployeeService(int size) {
			emps = new Employee[size];
		}
		//3.
		public static EmployeeService getInstance() {
			return service;
		}
		
		public void addEmployeeService (Employee e) {
			emps[idx++] = e;
		}
		
		public void deleteEmployee(String name) {
			for(int i = 0; i<idx; i++) {
				if(emps[i].getName().equals(name)) {
					for(int j = i; j<idx; j++) {
						emps[j] = emps[j+1];
					}
					emps[idx] = null;
					idx --; 
				}
			}
		}

		
		public void printEmployees(String job) {
			for(Employee employee: emps) {
				if(employee==null) continue;
				if(job.equals("m")) {
					if(employee instanceof Manager) {
						System.out.println(employee);
					}
				}
				if(job.equals("e")) {
					if(employee instanceof Engineer) {
						System.out.println(employee);
					}
				}
			}
		}
		
		
		public Employee findEmployee(String name) {
			Employee e = null;
			for(Employee employee: emps) {
				if(employee==null) continue;
				if(employee.getName().equals(name))
					e = employee;
			}
			return e;
		}
		public Employee[] findEmployee(int deptno) {
			Employee [] temp = new Employee[emps.length];
			int count = 0;
			for(Employee employee: emps) {
				if(employee==null) continue;
				if(employee instanceof Manager) {
					if(((Manager) employee).getDeptno()==deptno) {
						temp[count++] = employee;
					}
				}
			}
			return temp;
		}

		public void updateEmployee(String dept, int deptno, String name) {
			for(Employee employee: emps) {
				if(employee == null) continue;
				if(employee instanceof Manager) {
					if(employee.getName().equals(name)) {
						((Manager) employee).setDept(dept);
						((Manager) employee).setDeptno(deptno);
						
					
				}
			}
		}
		}
		public void updateEmployee(double salary, String name) {
			for(Employee employee: emps) {
				if (employee==null) continue;
				if(employee.getName().equals(name)) {
					employee.setSalary(salary);
					
				}
			}
		}
		public void updateEmployee(String tech, double bonus, String name) {
			for(Employee employee: emps) {
				if(employee==null) continue;
				if(employee instanceof Engineer) {
					if(employee.getName().equals(name)) {
						((Engineer) employee).setTech(tech);
						((Engineer) employee).setBonus(bonus);
						
					}
				}
			}
		}
		public void printAllEmployee(String name) {
			for(Employee employee: emps) {
				if(employee==null) continue;
				if(employee.getName().equals(name)) {
					System.out.println(employee);
				}
			}
		}
		//추가 총 비용(연봉 합산)
		
		public int getAnnualSalary(Employee e) {
			int annualSalary = 0;
			annualSalary = (int)(e.getSalary()*12);
			if(e instanceof Engineer)
				annualSalary = (int)(e.getSalary()*12+((Engineer) e).getBonus());
			return annualSalary;
		}
		public int getTotalCost() {
			int tc = 0;
			for(Employee employee: emps) {
				if(employee==null) continue;
				tc +=getAnnualSalary(employee);
				
			}
			return tc;
			
		}

}

