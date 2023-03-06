package com.kb.sms;

public class Test {

	public static void main(String[] args) {
		// 사용 1
		Student s = new Student();
		s.num = 1001;
		s.name = "kim";
		s.study();
		s.work(3); // 무조건 값을 넣어줘야 함. work에 time이 있다면
		Student s2 = new Student();
		s2.num = 1002;
		s2.name = "lee";
		s2.study();
		s2.work(5);
	}

}
