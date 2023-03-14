package day4.exhaustiveSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Permutation2 {

    static int N, R, totalCnt;
    static int[] numbers; // 선택한 숫자
    static boolean[] isSelected; // 현재까지 선택 여부
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        R = sc.nextInt();
        
        numbers = new int[R];
        isSelected = new boolean[N+1];
        
        perm(0);
        
        System.out.println(N + "P" + R + " = " + totalCnt);
    }
    
    private static void perm(int cnt) {
        if (cnt == R) { // 기저 조건
            totalCnt++;
            System.out.println(Arrays.toString(numbers));
            return;
        }
        
        for (int i = 1; i <= N; i++) {
            if (isSelected[i]) continue; // 이미 선택된 경우 skip
            
            numbers[cnt] = i;
            isSelected[i] = true;
            perm(cnt+1);
            isSelected[i] = false;
        }
    }

}