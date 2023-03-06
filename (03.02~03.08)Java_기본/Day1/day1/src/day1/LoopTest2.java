package day1;

public class LoopTest2 {

	public static void main(String[] args) {
		//1~100까지 짝수의 합을 구해보자.
		int sum = 0;
		for(int i = 2; i<101; i=i+2) {
			//1~100
			sum += i;
				
		}System.out.println(sum); //시간 복잡도 낫다
		
		//1~100까지 3의 배수의 합을 구하라. 단 3의 배수가 5의 배수가 될 때 종료한다.
		int num = 0;
		for(int n = 3; n<101; n=n+3) {
			if (n%5==0) {
				break;
			}else {
				num += n;
			}
		}System.out.println(num);
		//1~100까지 3의 배수의 합을 구하라. 단 3의 배수가 5의 배수가 될 때 합에서 제외 한다.
		int dum = 0;
		for(int d = 3; d<101; d=d+3) {
			if (d%5==0) {
				continue;
			}else {
				dum += d;
			}
		}System.out.println(dum);
	}//end main

}//end class
