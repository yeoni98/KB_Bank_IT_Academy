package com.edu.test;
/*
 * final
 * 
  <<access modifier>>
    => public/ protected / private
  <<usuage modifier>>
    => static/ abstract / final
    ex) static final int SPEED;
        final static int SPEED; 둘 다 상관 없음
        
  final ==> 마지막
  final + 변수(변수 앞에 쓰인다) == 마지막 변수야 ==상수야
  final + class == 마지막 클래스야 == 상속 금지
  final + method == 마지막 메소드야 == Overriding 금지
        
    
 */
class SuperAA{
	public static final int BASIC_SALARY = 3000000; //상수
	public final String test() {
		return "Overriding 금지";
	}
}

final class SuperA{ //상속 금지

}
//class Child extends SuperA{ => 상속 금지라서 못 만듦
//	
//}

//class ChildA extends SuperAA{ => Overriding 금지
////	BASIC_SALARY = 1000000; =>값 변경 안됨
//	public final String test() {
//		String name = "James";
//		return "Overriding 금지";
//	}
//}


public class FinalExamTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
