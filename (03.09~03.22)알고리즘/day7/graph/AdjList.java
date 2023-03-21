package day7.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AdjList {
	static ArrayList<Integer>[] adjList; // 인접 리스트
	static int N, E; // 정점 개수, 간선 개수
	static boolean [] visited;// 방문 여부

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		E = sc.nextInt();
		adjList = new ArrayList[N];
		visited = new boolean[N];
		
		for(int i = 0; i<N; i++) {
			adjList[i] = new ArrayList();
			
		}
		for(int i =0; i<E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjList[from].add(to);
			adjList[to].add(from); // 무방향 그래프
			
		}
		
		BFS(0); // 시작 정점: 0번 노드이다.
		System.out.println();
		visited = new boolean[N];
		visited[0] = true;
		DFS(0); // 시작 정점: 0
		

	}
	
	private static void DFS(int currNode) {
		System.out.print(currNode);
		for(int node : adjList[currNode]) {
			if(!visited[node]) {
				visited[node] = true;
				DFS(node);
			}
		}
	}
	private static void BFS(int startNode) {
		Queue<Integer> q = new LinkedList();//index 정보 => Integer
		
		//시작 정점 En-queue :0
		q.offer(startNode);
		visited[startNode] = true;
		
		while(!q.isEmpty()) {
			//De-queue
			int currNode = q.poll();
			System.out.print(currNode);
			//En-queue
			for(int node: adjList[currNode]) {
				if(!visited[node]) {
					q.offer(node);
					visited[node] = true;
				}
			}
		}
	}

}

/*
 * 
7
8
0 1
0 2
1 3
1 4
3 5
4 5
5 6
2 6
*/
