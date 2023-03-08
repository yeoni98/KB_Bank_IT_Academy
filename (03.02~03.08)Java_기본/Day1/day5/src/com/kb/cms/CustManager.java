package com.kb.cms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustManager implements ICustMgr {
	List<Customer> cs = new ArrayList<>();
	// 저장
	@Override
	public void save(Customer c) {
		cs.add(c);
	}
	// 검색
	@Override
	public void search() {
		for(Customer c: cs) {//cs로부터 하나씩 꺼내주자
			System.out.println(c); // c.toString()로 출력
			
		}
	}	
	public void sortedSearch() {
		//Collections.sort( cs);//이름으로 Sort, Comparable 구현
		Collections.sort(cs,new MyComparator("고객번호"));
		for(Customer c: cs) {//cs로부터 하나씩 꺼내주자
			System.out.println(c); // c.toString()로 출력
			
		}
	}
	// 상세검색
	@Override
	public Customer search(int num) {
	
		Customer result = null;
		for(Customer c: cs) {
			if(c.num == num)// c.num 이 파라메터의 num과 같다면 
				{
				result = c; //result에 넣고 빠져나온다
			break;
		}
	}
		return result;
	}
	// 수정 : 고객 주소 수정
		// 고객 정보 검색 - 주소 수정
	@Override
	public void update(int num, String address) {
		Customer c = search(num);
		if(c != null) {
			c.address = address;
		}else {System.out.println("수정 실패: 고객번호가 잘못 되었습니다.");
	}
	}
	// 삭제
	@Override
	public void delete(int num) {
		Customer c = search(num);
		if (c!=null) {
			cs.remove(c);
		}else {
			System.out.println("삭제 실패: 고객번호가 잘못 되었습니다.");
		}
		
	}
}

