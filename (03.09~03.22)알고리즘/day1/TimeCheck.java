package day1.array;

public class TimeCheck {

	public static void main(String[] args) {
		//한 줄 삭제 :cntrl+d
		int N = 500000; // int 범위 : 21억
		long start, end;
		int total = 0;
		
		start = System.currentTimeMillis(); // 현재시간 불러오는 함수
		for (int i = 0; i < N; i++) {
			total += i; 
		}
		end = System.currentTimeMillis();
		System.out.println(end-start);
		
		start = System.currentTimeMillis(); // 현재시간 불러오는 함수
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
			total += j; 
		} 
		}
		end = System.currentTimeMillis();
		System.out.println(end-start);
		}
	}


