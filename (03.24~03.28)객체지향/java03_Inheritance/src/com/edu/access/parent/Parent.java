package com.edu.access.parent;

public class Parent{
	public String publicVar = "publicVar";
	protected String protectedVar = "protectedVar";
	String var = "var";
	private String privateVar = "privateVar";
	
	public Parent(){ //생성자가 public 안 붙이면 안 붙인다. 붙이면 붙인다
		
	}
	public void access() {
		System.out.println("Access Modifier Test...");
	}
}