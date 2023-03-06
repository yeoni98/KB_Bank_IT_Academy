import java.util.Scanner;

public class Main9042 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int sum= 0;
		int num = 0;
		int cnt = 0;
		while(true) {
			num = s.nextInt();
			if (num ==0) {
				break;
			}else {
				cnt+=1;
				sum+=num;
				
			}
		}System.out.println("입력된 자료의 개수 = "+cnt);
		System.out.println("입력된 자료의 합계 = "+sum);
		System.out.println("입력된 자료의 평균 = "+String.format("%.2f",(sum/(float)(cnt))));

	}

}
