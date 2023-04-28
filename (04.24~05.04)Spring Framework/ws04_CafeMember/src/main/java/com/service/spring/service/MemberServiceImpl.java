package com.service.spring.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.dao.MemberDAO;

import com.service.spring.domain.MemberVO;
@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDAO memberDAO;
	@Override
	public int registerMember(MemberVO vo) throws Exception {
		return memberDAO.registerMember(vo);
	}

	@Override
	public int deleteMember(String id) throws Exception {
		return memberDAO.deleteMember(id);
				
	}

	@Override
	public int updateMember(MemberVO vo) throws Exception {
		return memberDAO.updateMember(vo);
	}

	@Override
	public MemberVO getMember(String id) throws Exception {
		return memberDAO.getMember(id);
	}

	@Override
	public List<MemberVO> showAllMember(MemberVO vo) throws Exception {
		return memberDAO.showAllMember(vo);
				
	}

	@Override
	public String idExist(String id) throws Exception {
		return memberDAO.idExist(id);
	}


}
