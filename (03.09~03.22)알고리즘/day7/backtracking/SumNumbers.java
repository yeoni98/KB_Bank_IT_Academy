package day7.backtracking;

import java.util.Arrays;

public class SumNumbers {
	static int N = 1000, M = 5, target = 150;
	static int[] arr = new int[N];
	static int[] select = new int[M];
	
	public static void main(String[] args) {
		for(int i=0; i<N; i++) {
			arr[i] = i+1;
		}
		backtracking(0,0,0); //0부터 탐색 하겠다. 0번째 숫자 뽑겠다
	}
	private static void backtracking(int cnt, int startIndex,int sum) { // cnt번째 숫자 뽑기
		if(cnt == M) {
			int total = 0;
			for(int x: select) total +=x; 
			if(total == target) System.out.println(Arrays.toString(select));
			return;
		}
		for(int i =startIndex; i<N; i++) {
			select[cnt] = arr[i];
			  if (sum + select[cnt] <= target) { // 누적 합이 target 이하일 때만 다음 숫자 선택 (백트래킹)
	                backtracking(cnt+1, i+1, sum+select[cnt]);
	            }
		
	}
	}
}
