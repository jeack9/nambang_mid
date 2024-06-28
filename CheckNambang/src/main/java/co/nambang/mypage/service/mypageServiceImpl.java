package co.nambang.mypage.service;

import org.apache.ibatis.session.SqlSession;

import co.nambang.common.DataSource;
import co.nambang.mypage.mapper.mypageMapper;
import co.nambang.mypage.vo.mypageVO;

public class mypageServiceImpl implements mypageService{
	

SqlSession sqlSession = DataSource.getInstance().openSession(true);	//true넣으면 자동 commit
mypageMapper mapper = sqlSession.getMapper(mypageMapper.class);	

	@Override
	public boolean modifyMember(mypageVO mvo) {
		// TODO Auto-generated method stub
		return mapper.mypageChange(mvo) == 1;
	}

}
