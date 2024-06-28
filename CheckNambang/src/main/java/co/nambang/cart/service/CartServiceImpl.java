package co.nambang.cart.service;

import org.apache.ibatis.session.SqlSession;

import co.nambang.cart.mapper.CartMapper;
import co.nambang.common.DataSource;


public class CartServiceImpl implements CartService{
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	CartMapper mapper = sqlSession.getMapper(CartMapper.class);
	
}
