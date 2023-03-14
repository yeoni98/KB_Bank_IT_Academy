package day3.sort;

import java.util.ArrayList;
import java.util.Collections;

class Person2{
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Person2 [age=");
		builder.append(age);
		builder.append(", money=");
		builder.append(money);
		builder.append("]");
		return builder.toString();
	}

	public Person2(int age, int money) {
		super();
		this.age = age;
		this.money = money;
	}

	int age, money;
}
public class UseSort2 {

	public static void main(String[] args) {
		ArrayList<Person2> arr = new ArrayList();
		arr.add(new Person2(25,100));
		arr.add(new Person2(20,100));
		arr.add(new Person2(23,100));
		arr.add(new Person2(21,100));
		System.out.println(arr.toString());
		
		//람다 함수 이용
		Collections.sort(arr,(p1,p2) -> p1.money - p2.money);
		System.out.println(arr.toString());
		
		//money가 같다면 age로 비교
		Collections.sort(arr, (p1,p2) -> p1.money!=p2.money ? p1.money-p2.money : p1.age-p2.age);
	}

}
