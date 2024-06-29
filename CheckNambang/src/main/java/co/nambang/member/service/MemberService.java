package co.nambang.member.service;

import co.nambang.member.vo.MemberVO;

public interface MemberService {
	public boolean joinMember(MemberVO mvo);
	public boolean modiAddr(String uid, int addrNo);
	public boolean checkId(String uid);
	public MemberVO login(MemberVO mvo);
}
