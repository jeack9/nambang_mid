package co.nambang.odproduct.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.nambang.common.DataSource;
import co.nambang.odproduct.mapper.OdProductMapper;
import co.nambang.odproduct.vo.OdProductVO;


public class OdProductServiceImpl implements OdProductService{
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	OdProductMapper mapper = sqlSession.getMapper(OdProductMapper.class);
	
	@Override
	public List<OdProductVO> orderHistoryList(int orderNo) {
		// TODO Auto-generated method stub
		return mapper.orderHistory(orderNo);
	}
	
}
