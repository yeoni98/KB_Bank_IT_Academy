package day3.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SortMethod {

	public static void main(String[] args) {
		// 1-1. 배열 정렬 - 정수
		
		int[] arr1 = {5,4,1,3,2};
		Arrays.sort(arr1);
		System.out.println(Arrays.toString(arr1));
		
		// 1-2. 배열 정렬 - 문자열
		String[] arr2 = {"apple", "samsung", "lg", "google"};
		Arrays.sort(arr2);
		System.out.println(Arrays.toString(arr2));
		
		// 2-1. ArrayList 정렬 - 정수/ 오름차순
		ArrayList<Integer> arr3 = new ArrayList();
		arr3.add(5);
		arr3.add(4);
		arr3.add(1);
		arr3.add(3);
		arr3.add(2);
		Collections.sort(arr3);
		System.out.println(arr3.toString());
		
		// 2-2.ArrayList 정렬 - 문자열/ 오름차순
		ArrayList<String> arr4 = new ArrayList();
		arr4.add("apple");
		arr4.add("samsung");
		arr4.add("lg");
		arr4.add("google");
		Collections.sort(arr4);
		System.out.println(arr4.toString());
		
		// 3. 내림차순 정렬 - Collections.reverseOrder()
		Integer[] arr5 = {5,4,1,3,2}; // Primitive 타입은 적용 불가
		Arrays.sort(arr5, Collections.reverseOrder());
		System.out.println(Arrays.toString(arr5));
		
		Arrays.sort(arr2, Collections.reverseOrder());
		System.out.println(Arrays.toString(arr2));
		
		Collections.sort(arr3,Collections.reverseOrder());
		System.out.println(arr3.toString());
		
		Collections.sort(arr4,Collections.reverseOrder());
		System.out.println(arr4.toString());
	}

}
