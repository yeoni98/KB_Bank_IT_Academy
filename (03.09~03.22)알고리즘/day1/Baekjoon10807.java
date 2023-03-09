package day1.array;

import java.util.Iterator;
import java.util.Scanner;

public class Baekjoon10807 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int [] arr = new int [n];
		for (int i =0; i<n; i++) {
			arr[i] = s.nextInt();
			
		}
		int v = s.nextInt();
		int result = 0;
		for(int i=0; i<n; i++) {
			if(arr[i]==v) {result++;}
			
		}
		System.out.println(result);
		
		
	}

}
