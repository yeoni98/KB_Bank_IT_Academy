package day1.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon2018 {

	public static void main(String[] args) throws IOException {
		BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(s.readLine());
		
		int numb = Integer.parseInt(st.nextToken());
		int cnt = 1;
		if (numb>2){
		for(int i = 1; i< (numb/2)+2; i++){
			int sum = i;
			for(int j = i+1; i<(numb/2)+2; j++) {
				
				if (sum==numb) {cnt++; break;
			}if(sum>numb) {
				break;
			}sum+=j;
		}


		}
	}System.out.println(cnt);
}
}