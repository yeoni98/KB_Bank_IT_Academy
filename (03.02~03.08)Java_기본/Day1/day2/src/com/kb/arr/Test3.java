package com.kb.arr;

public class Test3 {

	public static void main(String[] args) {
		int[] a = {10,20,30}; // stack 에 int 계열 a를 만들어라
		System.out.println(a[1]);
		System.out.println(a.length);
		for(int su: a) {
			System.out.println(su+" ");

		}
		System.out.println();

		int[][] b = {{10,20,30},{11,22,33}}; //2차원 배열
		System.out.println(b[1][1]); //2차원 배열일 땐 명확하게 행과 열을 명시해줘야 함. b[1]로 하면 안됨
		System.out.println(b.length); //*행의 길이
		System.out.println(b[0].length); //*열의 길이
		for(int[] bb: b) {  //1. ~ 이용한 2차원 배열
			for(int bbb: bb) {
				System.out.print(bbb+" ");
			}
			System.out.println();// 줄바꿈
			//10 20 30 
//			  11 22 33
			}
		for(int r=0; r<b.length; r++) {//2. for문 이용한 2차원 배열
			for(int c=0; c<b[r].length; c++) {
				System.out.print(b[r][c]+" ");
			}
			System.out.println();
		}
			
	}

}
// stack 은 매서드, main 수행공간