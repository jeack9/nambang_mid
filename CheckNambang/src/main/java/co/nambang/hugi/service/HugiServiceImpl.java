package co.nambang.hugi.service;

import org.apache.ibatis.session.SqlSession;

import co.nambang.common.DataSource;
import co.nambang.hugi.mapper.HugiMapper;
import co.nambang.hugi.vo.HugiVO;


public class HugiServiceImpl implements HugiService{
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	HugiMapper mapper = sqlSession.getMapper(HugiMapper.class);
	
	@Override
	public boolean hugiAdd(HugiVO hvo) {
		// TODO Auto-generated method stub
		return mapper.hugiUpdate(hvo) == 1;
	}
	
}
