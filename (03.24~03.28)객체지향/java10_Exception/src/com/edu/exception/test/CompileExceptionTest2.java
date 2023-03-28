package com.edu.exception.test;
/*
 CompileException
 1.컴파일 X::컴파일러가 인식
 2.반드시 명시적으로 예외처리해서 사용해야하는 일종의 문법구조
 3.
 */
import java.io.FileNotFoundException;
import java.io.FileReader;

class FileReading{
	public void readFile(String fileName) {
		try {
		//파일 불러들이는 api클래스 생성
		FileReader reader = new FileReader(fileName); //CompileException
		System.out.println("1. 파일을 잘 찾음");
		} catch(FileNotFoundException e) { // 비정상 종료 막도록
			System.out.println("1. 파일을 찾을 수 없음");
		}
		System.out.println("2. FileReader API Creating...");
	}
}
public class CompileExceptionTest2 {
	
	public static void main(String[] args) {
		FileReading fr = new FileReading(); // 객체 생성
		fr.readFile("C:\\KB\\workshop_homework\\java_r\\java_r1_Workshop.pdf"); // 함수 호출
		//   파일 정보 =        파일 경로                    +     파일명
		System.out.println("3. 파일을 잘 읽어들임.");
	}

}
