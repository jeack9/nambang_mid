package co.nambang.addr.service;

import org.apache.ibatis.session.SqlSession;

import co.nambang.addr.mapper.AddrMapper;
import co.nambang.addr.vo.AddrVO;
import co.nambang.common.DataSource;


public class AddrServiceImpl implements AddrService{
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	AddrMapper mapper = sqlSession.getMapper(AddrMapper.class);
	@Override
	public boolean addAddr(AddrVO avo) {
		return mapper.insertAddr(avo) == 1;
	}
	@Override
	public AddrVO getSelectedAddr(String userId, int addrSelected) {
		return mapper.selectAddr(userId, addrSelected);
	}
	
}
