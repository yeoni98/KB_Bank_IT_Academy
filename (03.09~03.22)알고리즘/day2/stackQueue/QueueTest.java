package day2.stackQueue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

	public static void main(String[] args) {
//		Queue <Integer> q = new Queue();  => 하면 안 됨. interface(미완성)이라서. stack은 되는데

		Queue<Integer> q = new LinkedList();
		q.offer(100);
		q.offer(200);
		q.offer(300);
		q.offer(400);
		q.offer(500);
		
		int front = q.poll();
		System.out.println(front);
		System.out.println(q);
		System.out.println(q.peek());
		while(!q.isEmpty()) {
			q.poll();
			System.out.println(q);
		}

	}

}
