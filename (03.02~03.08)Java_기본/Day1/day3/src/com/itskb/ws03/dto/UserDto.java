package com.itskb.ws03.dto;

import java.util.Scanner;
//객체는 데이터(변수)와 기능(처리) 
// 시스템: 어떤 목적을 갖고 있는 체계
//컴포넌트: 독립실행 가능한 코드의 묶음
//패키지: 그룹화 시켜서 논리적 묶음
//인스턴스 = 클래스 복제 된 것
public class UserDto {
	
		int userSeq;
		String name;
		String email;
		String phone;
		boolean isSleep;
		//생성자 만들어야됨 source - generate using fields -delete all/ select all/ toString()
		public UserDto() {
			
		}
		public UserDto(int userSeq, String name, String email, String phone, boolean isSleep) {
			
			this.userSeq = userSeq;
			this.name = name;
			this.email = email;
			this.phone = phone;
			this.isSleep = isSleep;
		}
		
		public String toString() {
			return "UserDto [userSeq=" + userSeq + ", name=" + name + ", email=" + email + ", phone=" + phone
					+ ", isSleep=" + isSleep + "]";
		}
		
		

	}

