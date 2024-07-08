package co.nambang.order.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import co.nambang.common.DataSource;
import co.nambang.order.mapper.OrderMapper;
import co.nambang.order.vo.OrderVO;


public class OrderServiceImpl implements OrderService{
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
	
	@Override
	public boolean addOrder(OrderVO ovo) {
		return mapper.insertOrder(ovo) == 1;
	}

	@Override
	public List<Map<String, Object>> orderHistroyList(String userId) {
		return mapper.orderHistroyList(userId);
	}
	
}
