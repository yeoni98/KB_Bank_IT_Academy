package day1;

public class DataTypeTest111 {

	public static void main(String[] args) {
		int i = 300;
		long a = 30L; //8byte 
		a = i;//8byte에 4byte 넣을수 있다, 
		//자동형변환 (int에서 long), 큰사이즈에 작은거 넣는거, 실수타입에 정수타입 넣는거 가능
		float b=3.4F; // 4byte,  저장하는법이 달라서 더 큰 a를 넣어도 에러 안남
		b=a;
		double d= 3.4;
		i = (int)d; //명시적형변환: 작은사이즈에 넣고 싶을때 <- (type)큰사이즈 로 넣으면 가능
		// 정수타입 <-(type)실수타입
		System.out.println(a+" "+b+" "+d+" "+i);
	}

}

// <identifier>
// -관습
//class명 : 앞글자 대문자
//변수,매서드, 패키지: 모두 소문자
//상수: 모두 대문자
// -문법
//첫글자는 숫자 x
//공백x
//예약어x