package com.kb.sms;

import java.lang.*;
import java.util.Scanner;

public class Student {
	int num;
	String name;
	Scanner s;
	
	public Student() {}
	public Student(int num, String name) {
		this.num = num;
		this.name = name;
	}
	
	static void study() {
		System.out.println("공부 중...");
	//왜 여기는 static	
	}
	void work(int time)//여긴 static 없는 이유? int time 은 왜 넣지?
	{
//		if(time==0) return; //종료하기 위함, not break
		System.out.println(time+" 시간동안 알바 중...");
//		work(--time); //1씩 감소하면서 다시 자기 자신을 불러냄 => 재귀어출?
	}
	

}
