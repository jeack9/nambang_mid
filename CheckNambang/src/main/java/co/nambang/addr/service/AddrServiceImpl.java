package co.nambang.addr.service;

import org.apache.ibatis.session.SqlSession;

import co.nambang.addr.mapper.AddrMapper;
import co.nambang.common.DataSource;


public class AddrServiceImpl implements AddrService{
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	AddrMapper mapper = sqlSession.getMapper(AddrMapper.class);
	
}
