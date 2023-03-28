package com.edu.service.impl;

import java.util.ArrayList;

import com.edu.exception.DuplicateIDException;
import com.edu.exception.RecordNotFoundException;
import com.edu.service.EmployeeListService;
import com.edu.vo.Employee;
import com.edu.vo.Engineer;
import com.edu.vo.Manager;

public class EmployeeListServiceImpl implements EmployeeListService {
	//필드 추가
	private ArrayList<Employee> list;
	
	//싱글톤
	private static EmployeeListServiceImpl service = new EmployeeListServiceImpl();
	private EmployeeListServiceImpl() {
		list = new ArrayList<>();	
	}
	public static EmployeeListServiceImpl getInstance() {
		return service;
	}
	
	@Override
	public void addEmployee(Employee e) throws DuplicateIDException {
		// 추가하고자 하는 직원이 존재한다면 추가 안 함./ 없을 때 추가
		boolean find = false;
		for(Employee emp : list) {
			if(emp.getEmpId().equals(e.getEmpId())) { // 추가하고자 하는 직원이 존자한다면
				find = true;
				// 사제폭탄을 터뜨림..
				throw new DuplicateIDException("해당하는 직원은 이미 등록된 상태입니다");
				
//				System.out.println(e.getName()+"님은 이미 직원으로 등록되어 있음.");
//				
//				return; //원래 호출한 지점으로 코드를 돌려 놓음			
			}
		}
		
		if(find==false) {//추가하려는 직원 없음
			list.add(e);
			System.out.println(e.getName()+"님은 직원으로 등록되었음");
		}
	}

	@Override
	public void deleteEmployee(String empId) throws RecordNotFoundException {
		// 삭제하고자 하는 직원이 존재한다면 삭제. 존재하지 않으면 삭제 x
		boolean find = false;
		for(Employee emp: list) {
			if(emp.getEmpId().equals(empId)) {
				find = true;
				System.out.println(emp.getName()+"님이 탈퇴함.");
				list.remove(emp);
				break;
				
			}
		}
		if(find == false) {
			throw new RecordNotFoundException("삭제할 대상이 이미 탈퇴한 상태");
			
		}
		
	}
//idx?
	@Override
	public void updateEmployee(Employee e) {
		boolean find= false;
        for(Employee emp : list) {
            if(emp.getEmpId().equals(e.getEmpId())) { //수정할 대상이 존재한다면
               find = true;
               emp.setName(e.getName());
               emp.setAddr(e.getAddr());
               emp.setSalary(e.getSalary());
               if(emp instanceof Manager) {
                   ((Manager) emp).changeDept(((Manager) e).getDept());
               }else {
                   ((Engineer) emp).changeTech(((Engineer) e).getTech());
                   ((Engineer) emp).changeBonus(((Engineer) e).getBonus());
               }
            }//if
        }//for
        if(find == false) System.out.println("존재하지 않음");
	}

	@Override
	public ArrayList<Employee> findEmployees(String addr) { //리턴타입이 컨테이너일때
		ArrayList<Employee> temp = new ArrayList<Employee>();
		for(Employee emp: list) {
			if(emp.getAddr().equals(addr)) {
				temp.add(emp);

			}
			}
			return temp;
			
		}
	


	@Override
	public void findEmployees() {
		for(Employee emp:list) {
			System.out.println(emp);
		}
		
	}
	

}
