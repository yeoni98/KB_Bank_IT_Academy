package com.service.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO{
	@Autowired      // 자동적으로 private 객체가 daoImpl에 주입이 된다.
	private SqlSession sqlSession;
	public static final String MAPPER_NAME = "MemberMapper."; // 원래 각 insert 마다 mapper.addUser이런식으로 붙여야 되는데 귀찮으니까..
	//DI  .. 주입되는 시점
	@Override
	public int registerMember(MemberVO vo) throws Exception {
		int result = sqlSession.insert(MAPPER_NAME+"registerMember", vo);
		return result;
	}
	@Override
	public int deleteMember(String id) throws Exception {
		int result = sqlSession.delete(MAPPER_NAME+"deleteMember", id);
		return result;
	}
	@Override
	public int updateMember(MemberVO vo) throws Exception {
		int result = sqlSession.update(MAPPER_NAME+"updateMember", vo);
		return result;
	}
	@Override
	public MemberVO getMember(String id) throws Exception {
		return sqlSession.selectOne(MAPPER_NAME+"getMember", id);
	}
	@Override
	public List<MemberVO> showAllMember(MemberVO vo) throws Exception {
		return sqlSession.selectList(MAPPER_NAME+"showAllMember", vo);
	}
	@Override
	public String idExist(String id) throws Exception {
		String result = sqlSession.selectOne(MAPPER_NAME+"idExist", id);
		return result;
	}
}
