package day2.stackQueue;

import java.util.ArrayList;
import java.util.LinkedList;

public class LinedListTest {

	public static void main(String[] args) {
		int N = 500000;
		long start, end;
		ArrayList<Integer> arr = new ArrayList(); // 배열
		LinkedList<Integer> list = new LinkedList(); // 리스트
		
		// 리스트 값 삽입
		start = System.currentTimeMillis();
		for (int i = 0; i<N; i++) {
			list.add(0,i);// 0번 인덱스 i 값 삽입  =>O(1) => 반복문 실행하면 O(N)이 됨
			
		}
		end = System.currentTimeMillis()
; System.out.println("반복문 실행 시간" + (end-start));
		// 배열 값 삽입

start = System.currentTimeMillis()
;		for(int i=0; i<N; i++) {
			arr.add(0,i);  //O(N) 인데 반복문 실행 시간은 O(N의 제곱)
			//만약 arr.add(i); 면 O(1) => 반복문 실행하면 O(N)이 됨
			
			
		}
end = System.currentTimeMillis()
;
System.out.println("반복문 실행시간"+(end-start));
		
	
	start = System.currentTimeMillis()
			;		for(int i=0; i<N; i++) {
						arr.add(i); 
						//만약 arr.add(i); 면 O(1) => 반복문 실행하면 O(N)이 됨
						
						
					}
			end = System.currentTimeMillis()
			;
			System.out.println("반복문 실행시간"+(end-start));

}
}
