package com.self.service;
import com.self.vo.Employee;
import com.self.vo.Engineer;

public interface EmployeeService {
	void deleteEmployee(String name) ;
    void updateEmployee(String name, double salary, String dept, int deptno, String tech, double bonus);
    Employee findEmployee(String name);
    Employee[] findEmployee(int deptno);
    void printEmployees();
	
}
