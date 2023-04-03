package com.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ServerInfo;

/*
DB연결한 후 데이터를 추가, 삭제, 수정, 반환하는 작업을 하기 위해서는
1. 드라이버를 메모리(DBConnectTest1.java가 실행되는 메모리)에 로딩..
   Class.forName("드라이버명") =>FQCN 형태로 넣어야 함 full qualified class name = 패키지명 포함한 이름으로 넣어야 함
2. DB연결
3.CRUD

db연결 프로그램에 서버정보에 관ㄱ련된 실제값이 하드코딩 되어져 있다.
드라이버 FQCN, 서버 주소, 계정 이름, 비번 등..
  ㅣ
  ㅣ
  Meta Data(의미를 간직한 파일)화(파일(xml, or properties파일 기반으로)로 분리) 해야 함.
  => 프로그램과 데이터를 분리해야 함.
  :: 
  1. 드라이버로딩
  2. 디비 연결 ---------Connection
  3. Preparedstatement ------ Preparedstatement/ResultSet
  4. 쿼리문 실행          ------ ResultSet
  ----------------------------
  5. 자원 반환...close()
     열린 순서 반대로 닫는다.
     반드시 닫아야 한다.... try~finally
     ResultSet
     Preparedstatement
     Connection
     
  
 */

public class DBConnectTest3 {
	public DBConnectTest3() throws ClassNotFoundException,SQLException{
		Connection conn = null; //선언이 try 블락 밖에 있어야 됨
		PreparedStatement ps = null;
		ResultSet rs  = null;
		try {
		//1. 드라이버 로딩
        Class.forName(ServerInfo.DRIVER_NAME);
        System.out.println("1.드라이버 로딩 성공");
        //2. 디비연결...Connection반환
        conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASS);
        System.out.println("2. 디비 연결 성공");
            //3. PreparedStatement 객체 생성..이때 인자값으로 쿼리문 입력(delete...333삭제)
        String query = "SELECT id, name, address FROM custom"; // 얘도 모듈화 시켜야 됨
        ps = conn.prepareStatement(query);
            //4. 쿼리문 실행
        rs = ps.executeQuery();
        
//        while(rs.next()){//row데이터가 있을때까지 실행
//        	System.out.println(rs.getInt(1)+"\t"
//        + rs.getString(2)+"\t"+rs.getString(3)); //colum명도 되고 index값도 됨 -> colum명으로 하자
//        }
        while(rs.next()){//BOE 다음부터 EOE전까지 , row데이터가 있을때까지 실행
//        	rs = ps.executeQuery();
        	System.out.println(rs.getInt("id")+"\t"
        + rs.getString("name")+"\t"+rs.getString("address")); //colum명도 되고 index값도 됨 -> colum명으로 하자
        }
		}finally {
			rs.close();
			ps.close();
			conn.close();
		}
        }
		
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		DBConnectTest3 db = new DBConnectTest3();
	}
	}


			    
