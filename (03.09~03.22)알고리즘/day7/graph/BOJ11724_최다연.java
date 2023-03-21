package day7.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ11724_최다연 {
	
	static int N, M,cnt;
	static boolean[] isVisited;
	static List<Integer>[] adjList;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		isVisited = new boolean[N+1];
		adjList = new ArrayList[N+1];
		
		for(int i = 1; i<N+1; i++) {
			adjList[i] = new ArrayList<>();
		}
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjList[from].add(to);
			adjList[to].add(from);
			
		}
		cnt = 0;
		for(int i = 1; i<N+1; i++) {
			if(!isVisited[i]) {
					
					BFS(i);
					cnt +=1;
				}

		}
		System.out.println(cnt);
		
	}
	
	private static void BFS(int start) {
		Queue<Integer> q = new LinkedList();
		q.add(start);
		isVisited[start] = true;
		while(!q.isEmpty()) {
			int x = q.poll();
			isVisited[x] = true;
			for(int node: adjList[x]) {
				if(!isVisited[node]) {
					isVisited[node] = true;
					q.add(node);
				}
			}
			
		}
	}

}
