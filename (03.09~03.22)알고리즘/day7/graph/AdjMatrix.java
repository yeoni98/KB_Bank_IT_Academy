package day7.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AdjMatrix {
	static int [][] adjMatrix; //인접행렬
	static int N, E; // 정점의 수, 간선의 수
	static boolean[] isVisited; // 방문 여부
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		E = sc.nextInt();
		adjMatrix = new int[N][N];
		isVisited = new boolean[N];
		
		for(int i = 0; i<E; i++) { // 정점은 0부터 시작
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjMatrix[from][to] = 1;
			
		}
		for(int i = 0; i<N; i++) {
			System.out.println(Arrays.toString(adjMatrix[i]));
		}
		
		BFS(0);
		isVisited = new boolean[N];
		isVisited[0] = true;
		System.out.println();
		DFS(0);
		
	}
	
	private static void DFS(int curr) {
		System.out.println(curr); // 방문
		
		for(int i = 0; i<N; i++) {
			if(adjMatrix[curr][i]!=0 && !isVisited[i]) {
				isVisited[i] = true;
				DFS(i);
				
				
			}
		}
	}
	private static void BFS(int start) {
		Queue<Integer> queue = new LinkedList();
		
		// 시작 노드 En-queue
		queue.offer(start);
		isVisited[start] = true;
		while(!queue.isEmpty()) {
			// De-queue
			int curr = queue.poll();
			System.out.print(curr);
			
			
			// En-queue : curr의 주변 정점 추가
			for (int i = 0; i<N; i++) {
				if(adjMatrix[curr][i]!=0 && !isVisited[i]) { //방문 안 했을 때
					isVisited[i] = true;
					queue.offer(i);
					
				}
			}
			
			
		}
	}

}

/*
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
