package co.nambang.member.service;

import org.apache.ibatis.session.SqlSession;

import co.nambang.common.DataSource;
import co.nambang.member.mapper.MemberMapper;


public class MemberServiceImpl implements MemberService{
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
	@Override
	public int joinMember() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
