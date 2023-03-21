package day7.graph;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ13023_최다연 {
	static int n, m;
	static boolean[] isVisited;
	static ArrayList<Integer> [] graph;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		graph = new ArrayList[n];
//	    isVisited = new boolean[n+1];
//	    nums = new ArrayList();
	    
		for(int i=0; i<n; i++) {
			graph[i] = new ArrayList<>();
		}
		for(int i=0; i<m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph[b].add(a);
			graph[a].add(b);
		}
		
		for(int i=0; i<n; i++) {
			isVisited = new boolean[n];
			DFS(i,0);
//			if (arrive == true) {
//				return;
//			}
		}
		System.out.println(0);
//		if(arrive==true) {
//			System.out.println(1);
//		}else System.out.println(0);
		
		

	}

	private static void DFS(int start, int depth) {
		isVisited[start] = true;
		if(depth ==4) {
			System.out.println(1);
			System.exit(0);
		}for(int i=0; i<graph[start].size(); i++) {
			int temp = graph[start].get(i);
			if(!isVisited[temp]) {
				DFS(temp, depth+1);
				isVisited[temp] = false;
				
			}
		}
		
	}
	

	}


