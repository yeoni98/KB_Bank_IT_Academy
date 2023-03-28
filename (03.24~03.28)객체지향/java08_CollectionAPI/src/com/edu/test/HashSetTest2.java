package com.edu.test;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest2 {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		set.add("F");
		set.add("B");
		set.add("A");
		set.add("C");
				
		System.out.println(set); //toString() 생략 되어있다.
//		[A, B, C, F] => 순서 없고 중복 없다
		System.out.println(set.size());
		boolean flag = set.remove("B");
		System.out.println("삭제가 진행됨?");
		System.out.println(flag);
		
		set.clear();
		System.out.println(set);
	}

}
