package day1;

public class LoopTest {

	public static void main(String[] args) {
		// for문
		for(int i=0; i<10; i++) {
			System.out.println("****");
			// 1. i=0 2. i<10 3.print 4.i++ / ++i해도 똑같음
			
		}
		for(int d =2; d<10; d++) {
			for (int i=1; i<10; i++) {
				System.out.println(d+"*"+i+"="+(d*i));
			
		}
			System.out.println("===================");
		}
//		int dan2 = 2;
//		for (int i=1; i<10; i++) {
//			System.out.println(dan2+"*"+i+"="+(dan2*i));
//		}
//		int dan3 = 3;
//		for (int i=1; i<10; i++) {
//			System.out.println(dan3+"*"+i+"="+(dan3*i));
//		}
//		int dan4 = 4;
//		for (int i=1; i<10; i++) {
//			System.out.println(dan4+"*"+i+"="+(dan4*i));
//		}
//		int dan5 = 5;
//		for (int i=1; i<10; i++) {
//			System.out.println(dan5+"*"+i+"="+(dan5*i));
//		}
//		int dan6 = 6;
//		for (int i=1; i<10; i++) {
//			System.out.println(dan6+"*"+i+"="+(dan6*i));
//		}
//		int dan7 = 7;
//		for (int i=1; i<10; i++) {
//			System.out.println(dan7+"*"+i+"="+(dan7*i));
//		}
//		int dan8 = 8;
//		for (int i=1; i<10; i++) {
//			System.out.println(dan8+"*"+i+"="+(dan8*i));
//		}
//		int dan9 = 9;
//		for (int i=1; i<10; i++) {
//			System.out.println(dan9+"*"+i+"="+(dan9*i));
//		}
		
		// for~each
		int[] su = {30,70,20,80,10}; //[] <= 배열이라는 뜻
		for(int i =0; i<su.length; i++) { //  배열명.length : 배열의 길이, 크기
			System.out.print(su[i]+" ");
			// 여러개 데이터를 가지고 작업
		}
		System.out.println();//줄바꿈
		for (int s:su) //su 중 한 개 꺼내서 처리하고.. 갯수만큼 반복한다 
			{
			System.out.print(s+" ");
		} // 전부 다 작업, 더 빠름(시간 효율성)
		/*
		//while
		while (조건) {
			//참인 동안 수행할 문장
			//참이어야만 수행, 수행이 안 될 수도 있음
			
		}
		
		// do~ while
		do {
			//무조건 먼저 작업
			//
			
		}while(조건); // 조건이 참이면 do 에서 계속 반복
		*/
		
	}//end main

}//end class
