package day6;

import java.util.Scanner;

public class BOJ_2839_최다연 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int rst = 0;
		
		while(n!=0) {
			if (n%5==0) {
				rst += n/5;
				n%=5;
				System.out.println(rst);
				break;
			}
			n-=3;
			rst +=1;
			if (n==0) {System.out.println(rst); break;}
			if(n<0) {System.out.println(-1); break;}
			
		}
		

	}

}
