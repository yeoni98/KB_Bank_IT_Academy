package day9.unionfind;

import java.util.Arrays;

public class UnionFind {
	static int N = 7;
	static int[] parents = new int[N];
	
	//크기가 1인 서로소 집합
	static void make() {
		for(int i = 0; i<N; i++) {
			parents[i] = i;
		}
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
		if (xRoot == yRoot) return; // x와 y가 같은 집합
		parents[yRoot] = xRoot;
		
	}
	// x와 y노드가 같은 집합인지 확인
	static boolean isSame(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		if (xRoot == yRoot) return true;
		else return false;	
	}
	
	public static void main(String[] args) {
		make();
		
		//{0}번 노드와 {1}번 노드와 유니언
		union(0,1);
		System.out.println(Arrays.toString(parents));
		
		//{0,1} U {2}
		union(1,2);
		System.out.println(Arrays.toString(parents));
		
		// 0노드와 2번 노드가 같은 집합인지 확인
		System.out.println(isSame(0,2));
		
	}

}
