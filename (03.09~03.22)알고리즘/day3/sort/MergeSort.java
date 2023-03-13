package day3.sort;

import java.util.Arrays;

public class MergeSort {

	
		static int[] arr = {5, 2, 8, 6, 4, 7, 3, 1};
	    static int[] temp = new int[arr.length]; // 임시 배열
	    
	    public static void main(String[] args) {
	    	mergeSort(0, arr.length-1);
	    	System.out.println(Arrays.toString(arr));
	    }

	    private static void mergeSort(int left, int right) {
	    	if(left >= right) return;
	    	
	    	int center = (left+right)/2;
	    	
	    	mergeSort(left, center);
	    	mergeSort(center+1, right);
	    	
	    	for (int i= left; i<= right; i++) {
	    		temp[i] = arr[i];
	    	}
	    	int currIdx = left;
	    	int leftIdx = left;
	    	int rightIdx = center +1;
	    	
	    	while (leftIdx <= center && rightIdx <= right) {
	    		if(temp[leftIdx] < temp[rightIdx]) {
	    			arr[currIdx++] = temp[leftIdx++];
	    		}
	    		else { arr[currIdx++] = temp[rightIdx++];
	    		
	    		}
	    	}
	    	while(leftIdx <= center) {
	    		arr[currIdx++] = temp[leftIdx++];
	    	}
	    	while(rightIdx <= right) {
	    		arr[currIdx++] = temp[rightIdx++];
	    	}
	    }
	
}

