package day5.tree;

import java.util.Arrays;
import java.util.Scanner;

public class CompleteTree {
	static char[] nodes;
	static int SIZE,LastIndex;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SIZE = sc.nextInt();
		nodes = new char[SIZE+1];
		LastIndex = SIZE;
		
		for(int i=1; i<=SIZE; i++) {
			nodes[i] =(char)('A' + (i-1));  // char + int 인데 자동으로 형 변환해준다.
		}
		System.out.println(Arrays.toString(nodes));
//		10
//		[ , A, B, C, D, E, F, G, H, I, J]
		getChild(1);
		getChild(5);
		getParent(5);
		
	}
	private static void getChild(int currIndex) {
		int left = currIndex*2;
		int right = currIndex*2+1;
		if(left <= LastIndex) System.out.println(nodes[left]);
		if(right <= LastIndex) System.out.println(nodes[right]);
	}
	private static void getParent(int currIndex) {
		int parent = currIndex/2;
		if(parent >=1) System.out.println(nodes[parent]);
	}

}
