package co.nambang.mypage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.nambang.mypage.vo.mypageVO;
import co.nambang.mypage.vo.orderhistoryVO;

public interface mypageMapper {
	 int mypageChange(mypageVO mvo);	// 정보 수정
	 List<orderhistoryVO> oderDetail(String userId);
	 List<mypageVO> mypageInfo(String userId);	// 정보 수정전 정보 목록
	 int checkPw(@Param("userPw")String userPw, @Param("userId")String userId);
}
