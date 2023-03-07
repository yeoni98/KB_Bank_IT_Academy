package com.itskb.ws02;

import java.io.FileInputStream;
import java.util.Scanner;

public class EvenOddSumDelta {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("src/EvenOddSumInput.txt"));
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] input = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				input[i][j] = sc.nextInt();
			}
		}

		int sum = 0;
		int[] dy = { -1, 1,  0, 0 };
		int[] dx = {  0, 0, -1, 1 };
		
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				int all = 0;

				for (int d = 0; d < 4; d++) {
					int ny = y + dy[d];
					int nx = x + dx[d];
					
					if( ny < 0 || nx < 0 || ny >= N || nx >= N ) continue;
					
					all += input[ny][nx];
				}
				
				if( all % 2 == 0 ) {
					sum += input[y][x];
//					System.out.println(y + " " + x + " " + input[y][x]);
				}
			}
		}
		
		System.out.println(sum);
		sc.close();
	}


}
