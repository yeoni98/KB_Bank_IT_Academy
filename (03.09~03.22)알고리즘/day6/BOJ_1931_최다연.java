package day6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ_1931_최다연 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [][] arr = new int[n][2];
		
		for(int i = 0; i<n; i++) {
			int a,b;
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		Arrays.sort(arr, new Comparator<int[]>() {
		    @Override
		    public int compare(int[] o1, int[] o2) {
		    	if(o1[1] == o2[1]) {
		    	return o1[0] - o2[0];
		    }
		    return o1[1] -o2[1];}
		});
		System.out.println(Arrays.deepToString(arr));
		int cnt = 1;
		int end = arr[0][1]; 
		for(int i=1; i<n; i++) {
				if(end<=arr[i][0]) {
					cnt++;
					end = arr[i][1];
			}
		}
		System.out.println(cnt);

	}

}
