package com.itskb.ws02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EvenOddSum2 {

	public static void main(String[] args) throws FileNotFoundException {
		//입력(키보드 입력 or file 입력)
		//1. 키보드 입력
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int[][] su = new int[size][size];
		for(int r=0; r<size; r++) {
			for(int c=0; c<size; c++) {
				su[r][c] = s.nextInt();
				
			}
		}
		//2. file 입력
		//Scanner s1 = new Scanner(new File("src/EvenOddSumInput.txt")); // 경로의 기준점은 프로젝트 밑
		//  Unhandled exception type FileNotFoundException(그 경로에 파일 없을 수 있다. 에러 날 수 있다 어떻게 할래=> throw~클릭= 상관없다/ surround => 에러 복구할게
		
		//처리
		//1. 이차원 배열 완전 탐색
		int total = 0;
		
		for(int r=0; r<size; r++) {
			for(int c=0; c<size; c++) {
				//2. su[r][c]의 상-하-좌-우 합 구하기. **경계를 넘으면 무시
				//3. 합이 짝수면 전체합에 += .
				int sum = 0;
				if(r-1>=0) sum+=su[r-1][c];//상
				if(r+1<size) sum+=su[r+1][c];//하
				if(c-1>=0) sum+=su[r][c-1];//좌
				if(c+1<size) sum+=su[r][c+1];//우
				if(sum%2==0) total+=su[r][c];
				
				
			}
		}
		System.out.println(total);
		//1번으로 반복
		//출력
		//전체 합 출력
		
		

	}

}
