package com.itskb.ws01;
import java.util.Random;

public class RandomUtil {
		int getRandomInt1(int from, int to) {
			//Math.random()  //0~1  , 1은 포함 안됨
			//Math.random() *(to-from) //to-from 3이라면 0~2.999
			int su = (int)(Math.random()*(to-from+1))+from;
			//2~5까지의 범위 때문에 5-2+1 값을 곱해주고 +from 값인2 더하면 5.9999 되는데 int 처리하면 5가 됨
			return su;
		}
		int getRandomInt2(int from, int to) {
			Random r = new Random();
			int su = r.nextInt(to-from+1)+from;
			return su;
		}
	
}

