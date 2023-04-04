package com.jdbc.client;

import java.sql.SQLException;
import java.util.ArrayList;

import com.jdbc.dao.MemberDAOImpl;
import com.jdbc.dto.Member;
import com.jdbc.exception.RecordNotFoundException;

import config.ServerInfo;

public class MemberDAOImplTest {

	public static void main(String[] args) throws RecordNotFoundException {
		MemberDAOImpl dao = MemberDAOImpl.getInstance();
		System.out.println("\n=============insertMember===================\n");
//		try {
//			dao.insertMember(new Member("길복순", "kill@daum.kr", "4444"));
//		}catch(Exception e) {
//			System.out.println(e.getMessage());
//		}
		System.out.println("\n==============deleteMember====================\n");
//		try {
//			dao.deleteMember(1);
//		}catch(Exception e) {
//			System.out.println(e.getMessage());
//		}
		
		System.out.println("\n==============updateMember====================\n");
//		
//		try {
//			dao.updateMember(new Member(2,"길복순", "kill@google.com", "777"));
//		}catch(Exception e) {
//			System.out.println(e.getMessage());
//		}
		
		System.out.println("\n===============getMember====================\n");
//		try {
//			Member member = dao.getMember(2);
//			System.out.println(member);
//		}catch(Exception e) {
//			System.out.println(e.getMessage());
//		}
//		
		System.out.println("\n===============getMember=====================\n");
		
		try {
			ArrayList<Member> list=dao.getMember();
			for(Member m : list) System.out.println(m);
		}catch(Exception e) {
			
		}
		
	}
	
	static {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("드라이버 로딩 성공..");
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패..");
		}
	}
}
