package day4.exhaustiveSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_15649 {
	static int N, R, totalCnt;
	static int[] numbers; 
	static boolean[] isSelected; 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //4개중에
		R = sc.nextInt(); // 3개 뽑겠다
		numbers = new int[R];
		isSelected = new boolean[N+1];
		
		perm(0);

	}
	private static void perm(int cnt) { // cnt: 현재 뽑아야 하는 카드 위치
		if (cnt == R) { // 기저 조건
//			totalCnt++;
			for(int i=0; i<numbers.length; i++) {
				System.out.print(numbers[i]+" ");
			}
			System.out.println();
			return;
			
			
		}
		
		
		for (int card = 1; card <= N; card++) {
			if(isSelected[card]) continue;
			numbers[cnt] = card; //cnt번째 카드는 card 카드 숫자 선택
			isSelected[card] = true;
			perm(cnt+1);
			isSelected[card] = false;
			
			
		}
	}
}
