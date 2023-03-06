package day1;

public class IfTest {

	public static void main(String[] args) {
		int score = 77;
		// if 1
		if (score > 70) {
			//조건이 참일 때 수행할 문제
			System.out.println("합격~~~");
		}
		// if 2
		if (score > 70) {
			System.out.println("합격~~");
		}else {
			System.out.println("불합격~~~");
		} //System = class, out = 변수, 
		// if 3
		if (score>=90) {
			System.out.println("A학점");
		}else if(score>=80) {
			System.out.println("B학점");
		}else if(score >=70) {
			System.out.println("C학점");
		}else {
			System.out.println("F학점");
		}
		// switch문 - else if 문을 단순화 시킨 것
		switch(score/10) {
		case 10: // 10으로 나누니 10이  나왔냐
			System.out.println("A");
			break;
		case 9:
			System.out.println("A");
			break;
		case 8:
			System.out.println("B");
			break;
		case 7:
			System.out.println("C");
			break;
		default: // 그렇지 않으면 =else
			System.out.println("F");
		}
		// 3항 연산
		int result = (score>70)? 100: 0; //70보다 크면 100 아니면 0 => (조건)? 참일때 값:거짓일때 값;
		System.out.println(result);

	}//end main()

}//end class
