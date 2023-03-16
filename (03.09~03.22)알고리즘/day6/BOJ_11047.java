package day6;

import java.util.Scanner;

public class BOJ_11047 {
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int [] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		int cnt =0;
		while(k!=0) {
			if(arr[n-1]>k) {
				n--;
			}if(arr[n-1]<=k) {
				cnt += k/arr[n-1];
				k=k%arr[n-1];
				n--;
				
			}
		}System.out.println(cnt);
	}
	

}
