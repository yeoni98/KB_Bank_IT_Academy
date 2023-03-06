package day1;

import java.util.Scanner;

public class InputTest {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in); // new => 메모리에 올려줘, s가 알고 있음, Scanner는 입력받는 대표적인 클래스, s는 참조값
		int a = s.nextInt(); // 정수 읽을 때 nextInt
		int c = s.nextInt();
		String b = s.next(); // 문자열 읽을 땐 next
		System.out.println(a+b+c);

	}

}


// study() 정의할 때
//1. static void study(){
//클래스 벗어나도 쓸 수 있음
//2. 예외임. 잘 안 씀. Student.study() 이렇게 써도 되지만 1번이 더 자주쓰임
