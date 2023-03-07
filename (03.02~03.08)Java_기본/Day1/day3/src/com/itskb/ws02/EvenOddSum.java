package com.itskb.ws02;

import java.io.FileInputStream;
import java.util.Scanner;

public class EvenOddSum {

	// 상하좌우의 합이 짝수이면 해당 좌표의 값을 sum 에 더한다.
	// 상,하,좌,우 중 경계를 벗어나는 경우는 제외하고 주변의 합을 계산한다.
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("src/EvenOddSumInput.txt")); //set(메서드)In => In을 바꾸겠다. =>In을 file로 바꾸겠다.
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] input = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				input[i][j] = sc.nextInt();
			}
		}

		int sum = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int top = 0;
				int bottom = 0;
				int left = 0;
				int right = 0;
				if( i-1 >=0 ) top = input[i-1][j];
				if( i+1 < N ) bottom = input[i+1][j];
				if( j-1 >=0 ) left = input[i][j-1];
				if( j+1 < N ) right = input[i][j+1];
				
				if( (top + bottom + left + right) % 2 == 0 ) {
					sum += input[i][j];
//					System.out.println(i + " " + j + " " + input[i][j]);
				}
			}
		}
		
		System.out.println(sum);
		sc.close();
	}

}