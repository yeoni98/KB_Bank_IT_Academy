package day7.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1325_solution {

	static int N, M;
	static boolean[] isVisited;
	static ArrayList<Integer>[] adjList;
	static ArrayList<Integer> nums;

	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int N = Integer.parseInt(st.nextToken());
	    int M = Integer.parseInt(st.nextToken());
	    
	    adjList = new ArrayList[N+1];
	    isVisited = new boolean[N+1];
	    nums = new ArrayList();
	    
	    for(int i = 1; i < N+1; i++) {
	        adjList[i] = new ArrayList();
	    }
	    
	    for(int i = 0; i < M; i++) {
	        st = new StringTokenizer(br.readLine());
	        int from = Integer.parseInt(st.nextToken());
	        int to = Integer.parseInt(st.nextToken());
	        
	        adjList[to].add(from);

	    }
	    
	    for(int i = 1; i < N+1; i++) {
	        nums.add(BFS(i));
	        isVisited = new boolean[N+1];
	    }
	    //System.out.println(nums.toString());
	    
	    int max = Collections.max(nums);
	    
	    for(int i = 0; i < nums.size(); i++) {
	        if(nums.get(i) == max) {
	            System.out.print((i+1) + " ");
	        }
	    }

	}

	private static int BFS(int startNode) {
	    Queue<Integer> queue = new LinkedList();
	    queue.offer(startNode);
	    isVisited[startNode] = true;
	    
	    int cnt = 0;
	    while(!queue.isEmpty()) {
	        int currNode = queue.poll();
	        //System.out.print(currNode);
	        for(int node : adjList[currNode]) {
	            
	            if(!isVisited[node]) {
	                cnt++;
	                queue.offer(node);
	                isVisited[node] = true;
	            }
	        }
	        
	    }
	    //System.out.println();
	    return cnt;
	    
	}
	}