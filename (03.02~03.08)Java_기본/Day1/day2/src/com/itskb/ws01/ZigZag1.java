package com.itskb.ws01;

public class ZigZag1 {

	public static void main(String[] args) {
		int [][] intArray = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20}};
		
		for (int i = 0; i<=intArray.length-1; i++) {
			if (i%2==0) {
				for(int l = 0; l<=intArray.length; l++)
				System.out.print(intArray[i][l]+" ");
				System.out.println();
			}
			else {
				for(int l = intArray.length; l>=0; l--) {
				System.out.print(intArray[i][l]+" ");
				
			}System.out.println();
		}

	}

}
}
