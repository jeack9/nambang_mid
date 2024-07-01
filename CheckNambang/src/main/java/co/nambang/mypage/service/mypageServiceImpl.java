package co.nambang.mypage.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.nambang.common.DataSource;
import co.nambang.mypage.mapper.mypageMapper;
import co.nambang.mypage.vo.mypageVO;
import co.nambang.mypage.vo.orderhistoryVO;

public class mypageServiceImpl implements mypageService{
	

SqlSession sqlSession = DataSource.getInstance().openSession(true);	//true넣으면 자동 commit
mypageMapper mapper = sqlSession.getMapper(mypageMapper.class);	

	@Override
	public boolean modifyMember(mypageVO mvo) {
		// TODO Auto-generated method stub
		return mapper.mypageChange(mvo) == 1;
	}

	@Override
	public List<orderhistoryVO> orderList(String userId) {
		// TODO Auto-generated method stub
		return mapper.oderDetail(userId);
	}

	@Override
	public List<mypageVO> mypageView(String userId) {	// 회원 정보 수정전 정보 보기 selec 구문
		// TODO Auto-generated method stub
		return mapper.mypageInfo(userId);
	}

	@Override
	public mypageVO currentPw() {
		// TODO Auto-generated method stub
		return null;
	}


}
