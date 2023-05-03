package com.service.spring.controller;

public class Person {
	private String name;
	private String address;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String toString() {
		return this.name + this.address;
	}
	public Person(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}

	
}
