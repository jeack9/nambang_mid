package co.nambang.zzim.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.nambang.common.DataSource;
import co.nambang.zzim.mapper.ZzimMapper;
import co.nambang.zzim.vo.ZzimVO;


public class ZzimServiceImpl implements ZzimService{
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	ZzimMapper mapper = sqlSession.getMapper(ZzimMapper.class);
	
	@Override
	public List<ZzimVO> zzimItems(String userId) {
		// TODO Auto-generated method stub
		return mapper.pickItems(userId);
	}

	@Override
	public boolean deleteZzimItems(int zzimNo) {
		// TODO Auto-generated method stub
		return mapper.pickDelete(zzimNo) == 1;
	}
	
}
