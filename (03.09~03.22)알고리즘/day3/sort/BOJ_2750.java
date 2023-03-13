package day3.sort;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2750 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		
		int n = s.nextInt();
		int [] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = s.nextInt();
		}

		
		
		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n; j++) {
			if (arr[i]>arr[j]) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		}
		for(int val: arr) {
			System.out.println(val);
		}
		
	}

	

}
