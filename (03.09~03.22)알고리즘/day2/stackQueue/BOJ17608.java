package day2.stackQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ17608 {

	public static void main(String[] args) throws IOException {
		Stack<Integer> stack = new Stack();
		BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(s.readLine());
		
		
		int n = Integer.parseInt(st.nextToken());
	
		for(int i =0; i<n; i++) {st = new StringTokenizer(s.readLine());
		int a = Integer.parseInt(st.nextToken());
			stack.push(a);
			System.out.println(stack.toString());
			
		}
		int min = stack.pop();
		int cnt = 1;
		for (int i=0; i<n-1; i++) {
			int numb = stack.pop();
			if(numb>min) {
				cnt+=1;
				min = numb;
			}
		}
		System.out.println(cnt);
	}

}
