package co.nambang.hugi.service;

import org.apache.ibatis.session.SqlSession;

import co.nambang.common.DataSource;
import co.nambang.hugi.mapper.HugiMapper;


public class HugiServiceImpl implements HugiService{
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	HugiMapper mapper = sqlSession.getMapper(HugiMapper.class);
	
}
