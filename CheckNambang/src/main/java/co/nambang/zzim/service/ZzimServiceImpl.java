package co.nambang.zzim.service;

import org.apache.ibatis.session.SqlSession;

import co.nambang.common.DataSource;
import co.nambang.zzim.mapper.ZzimMapper;


public class ZzimServiceImpl implements ZzimService{
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	ZzimMapper mapper = sqlSession.getMapper(ZzimMapper.class);
	
}
