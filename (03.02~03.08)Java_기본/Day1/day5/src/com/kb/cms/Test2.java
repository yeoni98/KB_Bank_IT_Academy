package com.kb.cms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test2 {
	// 모든 문장은 메인 메서드 안에 넣어줘야함
	public static void main(String[] args) {
		
	
	List<String> ss=new ArrayList<>();
	ss.add("Kim");
	ss.add("Lee");
	ss.add("Kang");
	ss.add("Bae");
	
	// 데이터가 Collection 일 경우 => Collections.sort()
	Collections.sort(ss); // 데이터를 정렬
	for(String s :ss) {
		System.out.println(s);
	}
	//또 다른 sort : 데이터가 배열인 경우 => Arrays.sort()
	System.out.println();
	String[] s2 = {"Kim","Lee","Kang","Bae"};
	Arrays.sort(s2);
	for(String s :s2) {
		System.out.println(s);
	}
	
	System.out.println(Arrays.toString(s2));
}
}