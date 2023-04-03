package com.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ServerInfo;

//비즈니스로직 :: 디비 ACCESS하는 로직... sql이 동작
/*
1. CustomerDAO객체 생성(== 메모리에 올린다)
2. CustomerDAO의 기능을 호출
*/
public class CustomerDAO {
	public CustomerDAO() {
		System.out.println("DAO CREATING...");
	}
	//DML, SELECT SQL이 각각의 기능에서 작동하도록 비지니스로직을 정의
	////////////공통적인 로직
	private Connection getConnect() throws SQLException{
		Connection conn=DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASS);
        System.out.println("DB Connection....OK");
        return conn;
	}
	private void closeAll(Connection conn, PreparedStatement ps) throws SQLException{
		if(ps!=null)ps. close();
		if(conn!=null)conn.close();
			
	}
	//Overloading
	private void closeAll(Connection conn, PreparedStatement ps,ResultSet rs) throws SQLException{
		if(rs!=null)rs.close();
		closeAll(conn,ps);
			
	}
	
	public void addCustomer(String ssn, String name, String addr) throws SQLException {
		Connection conn = null;
        PreparedStatement ps = null;
        try {
        	conn = getConnect();
        	
            conn=DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASS);
            System.out.println("DB Connection....OK");

            String query ="INSERT INTO customer (ssn, name, address) VALUES(?,?,?)";
            ps=  conn.prepareStatement(query);
            ps.setString(1, ssn);
            ps.setString(2, name);
            ps.setString(3, addr);

            int row = ps.executeUpdate();
            System.out.println(row+" row INSERT ok...");
        }finally {
            closeAll(conn,ps);
        }
    }
	///////// 비즈니스 로직 ////////

	public void removeCustomer(String ssn) throws SQLException {
		  Connection conn = null;
	        PreparedStatement ps = null;
	        try {
	            conn=DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASS);
	            System.out.println("DB Connection....OK");

	            String query ="DELETE customer WHERE ssn=?";
	            ps= conn.prepareStatement(query);
	            ps.setString(1, ssn);

	            int row = ps.executeUpdate();
	            System.out.println(row+" ROW DELETE OK~~!!");
	        }finally {
	        	closeAll(conn,ps);
	        }
	    }

		//delete
		
	
	public void updateCustomer(String ssn, String name, String addr) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			String query = "UPDATE customer SET name=? , address=? WHERE ssn=?";
			ps= conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, addr);
			ps.setString(3, ssn);
			int row = ps.executeUpdate();
			System.out.println(row+" row update ok..");
			 
			
		}finally {
			closeAll(conn,ps);
			
		}
    }
		
	
	public void printAllcustomer() throws SQLException {
		//select
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnect();
			String query = "SELECT ssn, name, address FROM customer" ;
			ps= conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString("ssn")+"\t"+rs.getString("name")+"\t"+ rs.getString("address"));
			}
		}finally {
			closeAll(conn,ps,rs);
		}
		
	}

	
}
