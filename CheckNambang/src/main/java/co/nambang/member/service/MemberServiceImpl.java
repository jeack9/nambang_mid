package co.nambang.member.service;

import org.apache.ibatis.session.SqlSession;

import co.nambang.common.DataSource;
import co.nambang.member.mapper.MemberMapper;
import co.nambang.member.vo.MemberVO;


public class MemberServiceImpl implements MemberService{
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
	@Override
	public boolean joinMember(MemberVO mvo) {
		return mapper.insertMember(mvo) == 1;
	}
	@Override
	public boolean modiAddr(String uid, int addrNo) {
		return mapper.updateBasicAddr(uid, addrNo) == 1;
	}
	@Override
	public boolean checkId(String uid) { // 등록된 id가 없으면 true전달
		return mapper.checkId(uid) == 0;
	}
	@Override
	public MemberVO login(MemberVO mvo) {
		return mapper.selectMember(mvo);
	}
	
}
