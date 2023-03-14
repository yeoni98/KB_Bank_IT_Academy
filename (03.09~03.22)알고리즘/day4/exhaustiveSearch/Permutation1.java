package day4.exhaustiveSearch;

import java.util.Arrays;
import java.util.Scanner;

public class Permutation1 {
	
	static int N, R, totalCnt;
	static int[] numbers; // 선택한 숫자
	static boolean[] isSelected; // 카드 선택 여부
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //4개중에
		R = sc.nextInt(); // 3개 뽑겠다
		numbers = new int[R];
		isSelected = new boolean[N+1];
		
		perm(0);
	}
	// 순열 함수
	private static void perm(int cnt) { // cnt: 현재 뽑아야 하는 카드 위치
		if (cnt == R) { // 기저 조건
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			System.out.println(Arrays.toString(isSelected));
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
