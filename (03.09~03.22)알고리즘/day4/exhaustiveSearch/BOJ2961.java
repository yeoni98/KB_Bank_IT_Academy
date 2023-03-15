package day4.exhaustiveSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ2961 {
	static int N;
	static int M;
	static int[][] material;
	static int total;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		material = new int[N][2];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			material[i][0] = Integer.parseInt(st.nextToken());
			material[i][1] = Integer.parseInt(st.nextToken());
			
		}
		total = Integer.MAX_VALUE;
		for(int i=1; i<=N;i++) {
			M = i;
			comb(0,new int[M],0);
		}
		
		System.out.println(total);
		}
		

	

	private static void comb(int toSelect, int[] selected, int startIdx) {
		if(toSelect ==M) {
			int s=1, b=0;
			for(int i=0;i<M; i++) {
				int idx = selected[i];
				s *= material[idx][0];
				b+= material[idx][1];
			}
			int res = Math.abs(s-b);
			total = Math.min(res, total);
			return;
		}
		for(int i=startIdx; i<N; i++) {
			selected[toSelect] = i;
			comb(toSelect+1,selected,i+1);
		}
		
	}

}
