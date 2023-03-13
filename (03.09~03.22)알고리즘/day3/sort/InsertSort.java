package day3.sort;

import java.util.Arrays;

public class InsertSort {

	
	    static int[] arr = {7, 2, 8, 1, 6, 3, 5};
	    public static void main(String[] args) {
	        insertionSort();
	        System.out.println(Arrays.toString(arr));
	    }
	    
	    private static void insertionSort() {
	        for (int i = 1; i < arr.length; i++) {
	            int insertIdx = i; // 삽입할 인덱스
	            
	            for (int j = 0; j < i; j++) {
	                // i 전까지 정렬된 상태이므로 arr[j]가 arr[i]보다 커지는 순간 j번째에 삽입
	                if (arr[j] > arr[i]) {
	                    insertIdx = j;
	                    break;
	                }
	            }
	            
	            // arr[i]를 저장한 뒤 insertIdx ~ i-1까지 한 칸씩 뒤로 밀기
	            int temp = arr[i];
	            for (int j = i-1; j >= insertIdx; j--) {
	                arr[j+1] = arr[j];
	            }
	            arr[insertIdx] = temp;
	        }
	    }
	}