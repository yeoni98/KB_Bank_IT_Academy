package day7.backtracking;

import java.util.Scanner;

public class BOJ9663_최다연 {
	static int n;
	static int[] arr;
	static int cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n];
		
		queen(0);
		System.out.println(cnt);
	}
	private static void queen(int depth) {
		if(depth == n) {
			cnt++;
			return;
		}
		for(int i = 0; i<n; i++) {
			arr[depth]= i;
			if (check(depth)) {
				queen(depth +1);
					}
		}
		}

	
	private static boolean check(int numb) {
		for (int i =0; i<numb; i++) {
			if (arr[numb] == arr[i] || Math.abs(arr[numb]-arr[i])==numb-i) {
				return false;
				}
		
			}
		return true;
	}
	}
	

	


