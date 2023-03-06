package day1;

public class OpTest {

	public static void main(String[] args) {
		int a = 100;
		int b = 3;
		// 산술연산자
		System.out.println(a+b);
		System.out.println(a-b);
		System.out.println(a*b);
		System.out.println(a/b);
		System.out.println(a%b);
		System.out.println(a++); // 나중에 다시 a출력하면 101 문장이 끝나고 나서 +1 증가시켜준다
		System.out.println(++b); // 4
		System.out.println(a);
		
		//비교연산자
		System.out.println(a>b);
		System.out.println(a<=b);
		
		//논리연산자
		System.out.println(a>b && --a>100);// 앞 조건이 TRUE일 경우 뒷 연산 수행
		System.out.println(a);
		System.out.println(a>b || --a>100); // 앞에가 참이라서 앞만 계산, 뒤에는 연산 안함/ false일 경우 연산 함
		System.out.println(a);
		System.out.println(a>b & --a>100);// 무조건 둘 다 수행
		System.out.println(a);
		System.out.println(a>b | --a>100); // 무조건 둘 다 수행
		System.out.println(a);

	}

}
