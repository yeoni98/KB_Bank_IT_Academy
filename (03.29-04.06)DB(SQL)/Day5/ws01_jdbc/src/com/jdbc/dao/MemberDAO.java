package com.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.DuplicateFormatFlagsException;

import com.jdbc.dto.Member;
import com.jdbc.exception.DuplicateIDException;
import com.jdbc.exception.RecordNotFoundException;

public interface MemberDAO {
	Connection getConnect() throws SQLException;
	void closeAll(Connection conn, PreparedStatement ps, ResultSet rs)throws SQLException;
	void closeAll(Connection conn, PreparedStatement ps)throws SQLException;
	//비즈니스 로직
	void deleteMember(int id) throws SQLException, RecordNotFoundException;
	void insertMember(Member dto) throws SQLException;
	void updateMember(Member dto) throws SQLException, RecordNotFoundException;
	Member getMember(int id) throws SQLException;
	ArrayList<Member> getMember()throws SQLException;
	ArrayList<Member> getMember(String name)throws SQLException;
	

	
}
