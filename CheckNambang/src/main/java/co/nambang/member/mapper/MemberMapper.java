package co.nambang.member.mapper;

import org.apache.ibatis.annotations.Param;

import co.nambang.member.vo.MemberVO;

public interface MemberMapper {
	// 로그인
	public MemberVO selectMember(MemberVO mvo);
	// 회원가입
	public int insertMember(MemberVO mvo);
	// 기본배송지 변경
	public int updateBasicAddr(@Param("uid") String uid, @Param("addrNo") int addrNo);
	// 아이디 중복체크
	public int checkId(String uid);
}
