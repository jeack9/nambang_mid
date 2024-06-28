package co.nambang.odproduct.service;

import org.apache.ibatis.session.SqlSession;

import co.nambang.common.DataSource;
import co.nambang.odproduct.mapper.OdProductMapper;


public class OdProductServiceImpl implements OdProductService{
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	OdProductMapper mapper = sqlSession.getMapper(OdProductMapper.class);
	
}
