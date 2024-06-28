package co.nambang.member.mapper;

import co.nambang.member.vo.MemberVO;

public interface MemberMapper {
	public MemberVO selectMember(String id);
	public int insertMember(MemberVO mvo);
}
