package com.kb.arr;

public class Test1 {

	public static void main(String[] args) {
		//배열 1.선언
		int[] s;//int타입의 배열 s다
		int a[];// 같음
		//2.생성
		s = new int[5]; //int타입의 배열 5개
		int[] b=new int[5]; //선언과 생성을 한꺼번에
		//3. 값할당
		s[0] = 11;
		s[1] = 22;
		int[] c = {11,22,33,44,55}; //선언과 생성과 값할당을 한꺼번에
		int[] d = new int[] {11,22,33,44,55};// 위와 같은 코드인데 매서드의 괄호에 값을 입력해서 바로 주고 싶을때 위에가 아니라 밑에 것을 써야 됨. 그 외엔 차이 없음
		
		m(c);
		m(d);
		
		m(new int[] {11,22,33,44,55}); //16번째줄
		//4. 검색
		System.out.println(s[1]);
		System.out.println(c[0]);
		for(int cc:c) { //c의 데이터 값의 개수만큼 반복한다.
			System.out.print(cc+" ");
		}
		

	}
	public static void m(int[] s) {
		
	}
}
