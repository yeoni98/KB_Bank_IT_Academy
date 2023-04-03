package com.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.DuplicateFormatFlagsException;

import com.jdbc.domain.Customer;
import com.jdbc.exception.DuplicateSSNException;
import com.jdbc.exception.RecordNotFoundException;

public interface CustomerDAO {
	// 공통적인 기능.. pulbic abstract
	Connection getConnect() throws SQLException;
	void closeAll(Connection conn, PreparedStatement ps) throws SQLException;
	void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException;

	// Business Logic Template
	void registerCustomer(Customer vo)throws SQLException,DuplicateFormatFlagsException, DuplicateSSNException;
	void removeCustomer(String ssn) throws SQLException,RecordNotFoundException;
	void updateCustomer(Customer vo)throws SQLException,RecordNotFoundException;
	Customer getCustomer(String ssn) throws SQLException;
	ArrayList<Customer>  getCustomer()throws SQLException;
	
}
