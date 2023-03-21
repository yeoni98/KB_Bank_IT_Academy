package day7.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2178_최다연 {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int n,m;
	static boolean [][] check;
	static int [][] ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		ans = new int[n][m];
		check = new boolean[n][m];
		for(int i = 0; i<n; i++) {
			String line = sc.next();
			for(int j = 0; j<m; j++) {
			ans[i][j] = line.charAt(j)-'0';
			
		}
		

	}
		BFS();

		System.out.println(ans[n-1][m-1]);

}
    private static void BFS() {
        Queue<Integer> qx = new LinkedList<Integer>();
        Queue<Integer> qy = new LinkedList<Integer>();
        
        qx.offer(0); qy.offer(0);
        check[0][0] = true;
        
        while(!qx.isEmpty()) {
        	int x = qx.poll();
        	int y = qy.poll();
        	
        	for(int i = 0; i<4; i++) {
        		int nx = x+dx[i];
        		int ny = y+dy[i];
        		
        		if(0<=nx && nx<n && 0<=ny && ny<m) {
        			if(ans[nx][ny]==1 && !check[nx][ny]) {
        				qx.offer(nx);
        				qy.offer(ny);
        				check[nx][ny] = true;
        				ans[nx][ny] = ans[x][y] +1;
        			}
        		}
        	}
        }

		
	}
}
