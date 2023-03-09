package day1.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon11659 {

	public static void main(String[] args) throws IOException {
		BufferedReader s = new BufferedReader(new InputStreamReader(System.in)); // String으로 받음
		StringTokenizer st = new StringTokenizer(s.readLine());
	
		int n = Integer.parseInt(st.nextToken()); // int로 바꿔준다
		int m = Integer.parseInt(st.nextToken());
		
		int [] arr = new int [n+1];
		st = new StringTokenizer(s.readLine());
		for(int i =1; i<=n; i++) {
		
			arr[i] = arr[i-1]+Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(s.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			System.out.println(arr[end]-arr[start-1]);	

	}

	}
}

