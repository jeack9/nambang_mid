package co.nambang.addr.service;

import java.util.List;

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
	public List<AddrVO> getSelectedAddr(String userId) {
		return mapper.selectAddr(userId);
	}
	@Override
	public boolean updateAddr(AddrVO avo) {
		// TODO Auto-generated method stub
		return mapper.updateAddr(avo) == 1;
	}
	@Override
	public boolean basicAddress(String userId) {
		// TODO Auto-generated method stub
		return mapper.basicAddr(userId) == 1;
	}
	@Override
	public boolean changeAddress(AddrVO avo) {
		// TODO Auto-generated method stub
		return mapper.changeAddr(avo) == 1;
	}
	
}
