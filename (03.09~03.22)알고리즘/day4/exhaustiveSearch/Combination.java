package day4.exhaustiveSearch;

import java.util.Arrays;
import java.util.Scanner;

public class Combination {
	
	static int N, R, totalCnt;
	static int[] numbers, arr; 
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //4개중에
		R = sc.nextInt(); // 3개 뽑겠다
		numbers = new int[R];
		arr = new int[N];
		for(int i = 0; i<N; i++) {
			arr[i] = sc.nextInt();
		}

	}
	//cnt : cnt번째 카드 뽑기
	//startIndex: arr에서 startIndex부터 카드 뽑기
	
	private static void comb(int cnt, int startIndex) {
		if(cnt==R) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for(int i= startIndex; i<N; i++) {
			numbers[cnt] = arr[i]; //cnt번째 숫자를 배열의 i번째 숫자로 지정
			comb(cnt+1, i+1);
		}
		
	}

}
