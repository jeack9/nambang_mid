package co.nambang.mypage.service;

import java.util.List;

import co.nambang.mypage.vo.mypageVO;
import co.nambang.mypage.vo.orderhistoryVO;

public interface mypageService {
	List<mypageVO> mypageView(String userId);	// 수정전 정보 조회
	boolean modifyMember(mypageVO mvo);
	List<orderhistoryVO> orderList(String userId);
	mypageVO currentPw();
}
