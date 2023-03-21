package day9.unionfind;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ1717_최다연 {
	static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        

     
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		//크기가 1인 서로소 집합
		parents = new int[N+1];
		for(int i = 1; i<=N; i++) {
			parents[i] = i;
		}
		
		for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
 
            if (command == 0) {
                union(a, b);
            } else if (command == 1) {
                sb.append((isSame(a, b) ? "YES" : "NO") + "\n");
            } else {
                continue;
            }
        }
 
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
			
		}

   
		// x의 대표 노드 반환
		static int find(int x) {
			if (parents[x] == x) return x;
			return parents[x] = find(parents[x]);
		}
		// x와 y를 유니언 하고 싶다
		static void union(int x, int y) {
			int xRoot = find(x);
			int yRoot = find(y);
			if (xRoot != yRoot) { // x와 y가 같은 집합
				if (xRoot<yRoot) {
					parents[yRoot] = x;
				}else {
					parents[xRoot] = y;
				}
			}
			
			
		}
		// x와 y노드가 같은 집합인지 확인
		static boolean isSame(int x, int y) {
			int xRoot = find(x);
			int yRoot = find(y);
			if (xRoot == yRoot) return true;
			return false;	
		
	}
		
}
