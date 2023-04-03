package com.jdbc.test;

import java.sql.SQLException;

import com.jdbc.dao.CustomerDAO;

import config.ServerInfo;


public class CustomerDAOTest {
	public static void main(String[] args) throws Exception {
		CustomerDAO dao = new CustomerDAO();
//		dao.addCustomer("222", "전도연", "방배동");
//		dao.removeCustomer("333");
//		dao.updateCustomer("111", "설경구", "방배동");
		dao.printAllcustomer();
	}//main
	
	static {
//		System.out.println("이것은...static...");
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("Driver Loading...");
		}catch(ClassNotFoundException e){
			System.out.println("Driver Loading...Fail...");
		}
	} // 원래는 메인이 먼저 실행되어야 하는데 이게 먼저 실행됨 .. 드라이버 로딩은, 초기화 작업은 원래 생성자 자리에 하는게 맞는데 static블락에다 하는게 맞음. 메인보다 먼저 실행되기 때문

}
