package com.edu.exception;

//empId가 존재하는 경우 발생하는 사용자 예외 클래스
public class DuplicateIDException extends Exception{
	public DuplicateIDException(){
//		super(); //this()랑 같이 쓸 수 없음
		this("This is DuplicateIDException..");
		
	}
	public DuplicateIDException(String message){
		super(message);
	}
	
	public static void main(String[] args) {
		

	}

}
