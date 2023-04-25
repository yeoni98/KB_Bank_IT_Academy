package spring.service.dice.impl;

import java.util.Random;

import spring.service.dice.Dice;

public class DiceDImpl implements Dice{
// Field
	private int value;
	
	public DiceDImpl() {
		System.out.println("::"+getClass().getName()+" 생성자....");
	}
	public DiceDImpl(int value) {
		System.out.println("::"+getClass().getName()+" 생성자....");
		this.value = value;}
	@Override
	public void selectedNumber() {
		value = new Random().nextInt(6) + 1; // value에 값을 할당
		
	}

	@Override
	public int getValue() {
		return value;
	}

}
