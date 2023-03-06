package com.kb.arr;

public class Test2 {
	static int[] su = {45,80,77,20,5,66,16,22,36,61}; 
		public static void main(String[] args) {
//		int sum, avg, max, gap = 0, 0, 0, 0;
		//총점 구하기
		System.out.println("총점:"+total());
		//평균 구하기
		System.out.println("평균:"+avg());
		//최대값 구하기
		System.out.println("최대값:"+max());
		//편차가 가장 큰 값 위치 구하기
		std();

	}
	public static int total() {
		int sum = 0;
		for(int s :su) {
			sum += s;
		}
		return sum;
	}
	public static double avg() {
		return total()/(double)su.length;

		
	}
	public static double max() {
		int maxnum = su[0];
		for(int i=1; i<su.length; i++) {
			if (su[i]>maxnum) 
				maxnum = su[i];
		}
		return maxnum;
		
	}
	//Scanner s = new Scanner(System.in);
	//int n = s.nextInt();
	//Intefer.parseInt("122") -> 숫자 변환
	//절대값: Math.abs(값 또는 식)
	//반올림: Math.round(값 또는 식) -- 두번째 자리 => Math.round(값*100)/100 사실 이거 말고 String.format("%.2f", 값 연산식)
	
	public static void std() {
		int stdMaxValue=su[0];
		int stdMaxIndex=0;
		double a = avg();
		for(int i=1; i<su.length; i++) {
			if (Math.abs(su[i]-a)>Math.abs(stdMaxValue-a)) {
				stdMaxValue = su[i];
			    stdMaxIndex = i;}
			    
		}
		
		System.out.println("표준편차가 가장 큰 값: "+stdMaxValue);
		System.out.println("표준편차가 가장 큰 위치: "+stdMaxIndex);
	}

}
