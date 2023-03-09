package day1.array;

import java.util.Arrays;
import java.util.Iterator;

public class Array {

	public static void main(String[] args) {
		int [] arr = new int[] {100,200,300,400,500};
		System.out.println(arr[2]);
		arr[3] = 999;
		System.out.println(Arrays.toString(arr));
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		int[][] arr2 = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
		arr2[1][1] = 999;
		System.out.println(Arrays.deepToString(arr2));
		

	}

}
