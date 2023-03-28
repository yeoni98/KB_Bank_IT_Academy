package com.edu.test;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest3 {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<>();
		list.add("F");
		list.add("B");
		list.add("C");
		list.add("B");
		list.add("A");
		list.add("B");
		
		System.out.println(list); //중복 허용
		//1. B를 삭제 => 삭제된 값을 return
		System.out.println(list.remove(1)); //remove => Overroding, 삭제된 값을 return
		//2. B를 삭제 => 가장 앞에 있는 것 삭제
		list.remove("B");
		System.out.println(list);
		//3.맨 처음에 HH를 추가
		list.add(0,"HH");
		System.out.println(list);
		//4. 3번째 데이터 츌력
		System.out.println(list.get(2));
	}
}
