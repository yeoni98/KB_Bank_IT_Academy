package day1.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon11660 {

	public static void main(String[] args) throws IOException {
		BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(s.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		
		int[][] arr = new int [n+1][n+1];
		int[][] dp = new int [n+1][n+1];
		
		for (int i = 1; i<=n; i++) {st = new StringTokenizer(s.readLine());
			for(int j = 1; j<=n; j++) {
				arr[i][j]= dp[i-1][j]+dp[i][j-1]+dp[i-1][j-1]+Integer.parseInt(st.nextToken());
				
			}
		}
		
		for (int i = 1; i<=n; i++) {
		for(int j = 1; j<=n; j++) {
		
			dp[i][j] = dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1]+arr[i][j];
			
			
		}
	}
	
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(s.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int r = dp[c][d]-dp[c][b-1]-dp[a-1][d]+dp[a-1][b-1];
			System.out.println(r);
		}
		
	}

}

