package com.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.DuplicateFormatFlagsException;

import com.jdbc.dto.Member;
import com.jdbc.exception.DuplicateIDException;
import com.jdbc.exception.RecordNotFoundException;

import config.ServerInfo;

public class MemberDAOImpl implements MemberDAO {
	private static MemberDAOImpl dao = new MemberDAOImpl();
	private MemberDAOImpl() {
		
	}
	public static MemberDAOImpl getInstance() {return dao;}

	@Override
	public Connection getConnect() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASS);
		System.out.println("DB Connection...OK");
		return conn;
	}
	@Override
	public void closeAll(Connection conn, PreparedStatement ps) throws SQLException {
		if(ps!=null)ps.close();
		if(conn!=null)conn.close();
	}

	@Override
	public void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException {
		if(rs!=null)rs.close();
		closeAll(conn, ps);
		
	}

	private boolean idExist(int ssn, Connection conn) throws SQLException{
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String query = "SELECT id FROM member WHERE id=?";
		ps = conn.prepareStatement(query);
		ps.setInt(1, ssn);
		rs = ps.executeQuery();
		return rs.next();
	}
	@Override
	public void insertMember(Member dto) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			String query = "INSERT INTO member(id, name,email, phone)VALUES(seq_id.nextVal,?,?,?) ";
				ps = conn.prepareStatement(query);
				ps.setString(1, dto.getName());
				ps.setString(2, dto.getEmail());
				ps.setString(3, dto.getPhone());
				System.out.println(ps.executeUpdate()+" row INSERT OK~~!");
//			}else {
//				throw new DuplicateIDException("이미 존재하는 고객입니다.");
			
		}finally {
			closeAll(conn,ps);
		}
	}

	@Override
	public void deleteMember(int id) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect(); //꼭
			if(idExist(id,conn)) {
				String query = "DELETE member WHERE id=?";
				ps = conn.prepareStatement(query);
				ps.setInt(1, id);
				System.out.println(ps.executeUpdate()+" row DELETE OK");
			}else {
				throw new RecordNotFoundException("삭제대상의 회원님이 존재하지 않습니다");
			}
		}finally {
			closeAll(conn,ps);
		}
		
	}

	@Override
	public void updateMember(Member dto) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			if(idExist(dto.getId(),conn)) {
			String query = "UPDATE member SET name=?, email=?, phone =? WHERE id=? ";
			ps = conn.prepareStatement(query);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getEmail());
			ps.setString(3, dto.getPhone());
			ps.setInt(4, dto.getId());
			
			int row = ps.executeUpdate();
			if(row==1) System.out.println(row+" 명 UPDATE OK... UPDATEMember...");
			else throw new RecordNotFoundException("수정할 대상의 고객이 존재하지 않습니다.");
			}
			
		}finally {
			closeAll(conn, ps);
		}
		
	}

	@SuppressWarnings("null")
	@Override
	public Member getMember(int id) throws SQLException {
		Connection conn=null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		Member member = null;
		
		try {
			conn = getConnect();
			String query = "SELECT id, name, email, phone FROM member WHERE id=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				member = new Member(rs.getInt("id"),rs.getString("name"), rs.getString("email"), rs.getString("phone"));
			}
		}finally {
			closeAll(conn,ps,rs);
		}
		return member;
	}
//
	@Override
	public ArrayList<Member> getMember() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Member> members = new ArrayList<>();
		try {
			conn = getConnect();
			String query = "SELECT id, name, email, phone FROM member";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				members.add(new Member(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("phone"))); //vo 동기화 중요
			}
			
			
			
		}finally {
			closeAll(conn,ps,rs);
		}
		return members;
	}
	@Override
	public ArrayList<Member> getMember(String ssn) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
////	@Override
////	public void deleteMember(String ssn) throws SQLException, RecordNotFoundException {
////		// TODO Auto-generated method stub
////		
////	}
//	@Override
//	public void deleteMember(int id) throws SQLException, RecordNotFoundException {
//		// TODO Auto-generated method stub
//		
//	}


}
