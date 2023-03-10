package day2.stackQueue;

import java.util.Stack;

public class StackTest {

		public static void main(String[] args) {
			Stack<Integer> stack = new Stack();
			stack.push(100);
			stack.push(200);
			stack.push(300);
			stack.push(400);
			stack.push(500);
			System.out.println(stack.toString());
			
			int top = stack.pop();
		
			System.out.println("제거된 값 " +top+" 제거 후 스택 "+stack);
			System.out.println(stack.peek().toString());
			while (!stack.isEmpty()) {
				top = stack.pop();
				System.out.println(top);
					
			}

		}

	}
