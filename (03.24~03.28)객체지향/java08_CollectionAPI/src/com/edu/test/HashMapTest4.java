package com.edu.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapTest4 {
	public static void main(String[] args) {
		Map<String,Integer> map = new HashMap<>();
		map.put("강호동", 85);
		map.put("이수근", 85);
		map.put("서장훈", 85);
		map.put("김희철", 85);
		
		//1. map에 담겨있는 모든 key값을 받아온다.
		Set<String> keys = map.keySet();
		System.out.println(keys);
		//2. key에 매핑된 점수를 받아서 모든 성적의 total 점수를 출력

		int total = 0;
		for(String name: keys) {
			total += map.get(name);
		}
		System.out.println(total);
		
		//3. 아는형님 멤버들의 평균 점수를 출력
		int avg = 0;
		avg = total/map.size();
		System.out.println(avg);
		//

	}

}
