package co.nambang.cart.service;

import org.apache.ibatis.session.SqlSession;

import co.nambang.cart.mapper.CartMapper;
import co.nambang.cart.vo.CartVO;
import co.nambang.common.DataSource;


public class CartServiceImpl implements CartService{
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	CartMapper mapper = sqlSession.getMapper(CartMapper.class);
	
	@Override
	public boolean addCart(CartVO cvo) {
		return mapper.addCart(cvo) == 1;
	}
	@Override
	public boolean checkCart(CartVO cvo) {
		// TODO Auto-generated method stub
		return mapper.selectCart(cvo) == 1; // 있으면 true 값
	}
	
	@Override
	public boolean updateCart(CartVO cvo) {
		// TODO Auto-generated method stub
		return mapper.updateCart(cvo) == 1;
	}

}
