package com.jdbc.dto;

public class Member {
	private int id;
	private String name;
	private String email;
	private String phone;
	
	public Member(int id,String name, String email, String phone) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		//id값은 디비에서 추가 될 때 자동 증가 됨.
	}
	public Member(String name, String email, String phone) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		//id값은 디비에서 추가 될 때 자동 증가 됨.
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	

}
