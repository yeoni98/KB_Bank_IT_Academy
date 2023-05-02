package com.service.spring.dao;

import java.util.List;

import com.service.spring.domain.MemberVO;

public interface MemberDAO {
	int registerMember(MemberVO vo) throws Exception;
	int deleteMember(String id) throws Exception;
	int updateMember(MemberVO vo) throws Exception;
	
	MemberVO getMember(String id) throws Exception;
	List<MemberVO> showAllMember(MemberVO vo)  throws Exception;
	
	String idExist(String id) throws Exception;

}