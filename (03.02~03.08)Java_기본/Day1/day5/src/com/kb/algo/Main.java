package com.kb.algo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		//1. 키보드 입력
//		Scanner s = new Scanner(System.in);
		
		//2. file 입력
//		Scanner s = new Scanner(new File("input.txt")); //프로젝트 폴더 아래 input.txt
//		int su = s.nextInt();
//		int su2 = s.nextInt();
//		System.out.println(su+" "+su2);
		//3. 
//		System.setIn(new FileInputStream("input.txt"));
//		Scanner s = new Scanner(System.in);
//		int su = s.nextInt();
//		int su2 = s.nextInt();
//		System.out.println(su+" "+su2);
		//4. 파일 입력
//		FileInputStream fis = new FileInputStream("input.txt"); //file에서 8bit씩 읽어온다
//		InputStreamReader isr = new InputStreamReader(fis); // 8bit -> 16bit으로 변경
//		BufferedReader br = new BufferedReader(isr);
		
		BufferedReader br = new BufferedReader(
				        new InputStreamReader(
						new FileInputStream("input.txt"))); 
		//FileInputStream -> BufferedReader 순으로 읽기
		
		String data = br.readLine();
		System.out.println(data);
		String[] d = data.split(" "); // 공백으로 data 분리해서 배열에 담는다.
		
			int[] sd = new int[d.length];
			for (int i = 0; i<d.length; i++) {
				sd[i] = Integer.parseInt(d[i]);//string 을 int로 바꿀 때 integer로
				//double 형태면(실수) -> Double.parseInt(d[i])
	}
			
		System.out.println(Arrays.toString(sd));
		
		

	}

	
	

}
