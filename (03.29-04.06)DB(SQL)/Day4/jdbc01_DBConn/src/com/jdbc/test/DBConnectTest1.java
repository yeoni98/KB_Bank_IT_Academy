package com.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
DB연결한 후 데이터를 추가, 삭제, 수정, 반환하는 작업을 하기 위해서는
1. 드라이버를 메모리(DBConnectTest1.java가 실행되는 메모리)에 로딩..
   Class.forName("드라이버명") =>FQCN 형태로 넣어야 함 full qualified class name = 패키지명 포함한 이름으로 넣어야 함
2. DB연결
3.CRUD




 */

public class DBConnectTest1 {
	
	public static void main(String[] args) {
		
		try {
			//1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 패키지명 포함한 풀 네임으로 넣어줄 것
			System.out.println("1. Driver Loading... Success..");
			
			//2. DB연결 1)DB서버 주소 2)계정 3)계정 비번
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "kb_db", "1234"); //꼭 이렇게 받아주는 부분이 있어야 함.
			System.out.println("2. DB Connect... Success..");
			
			//3. CRUD작업... db서버와 연결이 이뤄져야만 가능
			String query = "INSERT INTO custom(id, name, address) VALUES(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query); //리턴 받음
			System.out.println("3. PreparedStatment...Creating..");
			
			//?에 대한 값 바인딩
			ps.setInt(1,444); // 첫 번째 ?에 111값을
			ps.setString(2,"미쉘"); // 두 번째 ?에 길복순이라는 값을
			ps.setString(3,"보스턴"); // 세 번째 ?에 여의도라는 값을
			
			System.out.println("=======INSER=======");
			//진짜 쿼리문이 실행.. excuteUpdate()
			System.out.println(ps.executeUpdate()+" row INSERT OK~~!!");
			
			
		} catch (ClassNotFoundException e) {
//			e.printStackTrace(); // 빼야됨 => 보안상 노출 우려 때문에
			System.out.println("1. Driving Loading... Fail...");
		} catch (SQLException e) {
			System.out.println("1. Driving Loading... Fail...");
		} //build path잡는것 정도는 알아야 함

	}

}
