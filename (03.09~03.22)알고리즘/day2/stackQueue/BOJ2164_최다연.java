package day2.stackQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BOJ2164_최다연 {

	public static void main(String[] args) {
		Deque<Integer> q = new ArrayDeque<Integer>();
		Scanner s  = new Scanner(System.in);
		
		int n = s.nextInt();
		for(int i=1; i<=n; i++) {
			q.offer(i);
		}while(q.size()!=1) {
			q.poll();
			q.offer(q.poll());
		}System.out.println(q.poll());

	}

}
