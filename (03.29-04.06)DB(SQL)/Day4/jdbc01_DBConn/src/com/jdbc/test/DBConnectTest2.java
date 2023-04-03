package com.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
DB연결한 후 데이터를 추가, 삭제, 수정, 반환하는 작업을 하기 위해서는
1. 드라이버를 메모리(DBConnectTest1.java가 실행되는 메모리)에 로딩..
   Class.forName("드라이버명") =>FQCN 형태로 넣어야 함 full qualified class name = 패키지명 포함한 이름으로 넣어야 함
2. DB연결
3.CRUD




 */

public class DBConnectTest2 {
	
	public static void main(String[] args) {
		
		try {
			
			        
			        //1. 드라이버 로딩
			        Class.forName("oracle.jdbc.driver.OracleDriver");
			        System.out.println("1.드라이버 로딩 성공");
			        //2. 디비연결...Connection반환
			        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "kb_db", "1234");
			        System.out.println("2. 디비 연결 성공");
//			            //3. PreparedStatement 객체 생성..이때 인자값으로 쿼리문 입력(delete...333삭제)
//			            String query = "DELETE FROM custom WHERE id = ?";
//			            PreparedStatement ps = conn.prepareStatement(query);
//			            ps.setInt(1, 333);
//			            System.out.println("ps 객체 생성");
//			            //4. 쿼리문 실행
//			            System.out.println(ps.executeUpdate()+ "row DELETE OK~~!!");
			        
			        
//			        
//			        String query = "UPDATE custom SET address=? WHERE id=111";
//			        PreparedStatement ps = conn.prepareStatement(query);
//			        ps.setString(1, "뉴욕");
//			        System.out.println(ps.executeUpdate()+ " ROW UPDATE OK~~!!");

			        String query = "SELECT id, name, address FROM custom";
			        PreparedStatement ps = conn.prepareStatement(query);
			        ResultSet rs  = ps.executeQuery();
			        
			        while(rs.next()){//row데이터가 있을때까지 실행
			        	System.out.println(rs.getInt(1)+"\t"
			        + rs.getString(2)+"\t"+rs.getString(3)); //colum명도 되고 index값도 됨
			        }
			    } catch (ClassNotFoundException e) {
			        System.out.println("1. Driver Loading......Fail....");
//			            e.printStackTrace();
			        } catch (SQLException e) {
			            System.out.println("1. DB Connect......Fail....");
			        }
		}
	}


			    
