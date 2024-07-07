package co.nambang.cart.service;

import java.util.List;
import java.util.Map;

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
	@Override
	public List<Map<String, Object>> cartList(String userId) {
		// TODO Auto-generated method stub
		return mapper.cartList(userId);
	}
	@Override
	public CartVO getCart(int cartNo) {
		return mapper.getCart(cartNo);
	}
	@Override
	public boolean editCart(CartVO cvo) {
		return mapper.editCart(cvo) == 1;
	}
	@Override
	public boolean removeCart(int cartNo) {
		return mapper.deleteCart(cartNo) == 1;
	}
	@Override
	public boolean delCarts(int[] cartNoArr) {
		return mapper.delCarts(cartNoArr) > 0;
	}

}
