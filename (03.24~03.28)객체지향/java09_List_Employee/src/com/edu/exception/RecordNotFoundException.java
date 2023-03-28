package com.edu.exception;

//수정, 삭제할 대상이 없을 때 발생하는 사용자 예외 클래스
public class RecordNotFoundException extends Exception{
	public RecordNotFoundException(){
//		super(); //this()랑 같이 쓸 수 없음
		this("This is RecordNotFoundException..");
		
	}
	public RecordNotFoundException(String message){
		super(message);
	}
	
	public static void main(String[] args) {
		

	}

}
