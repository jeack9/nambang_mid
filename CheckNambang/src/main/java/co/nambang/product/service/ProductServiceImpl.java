package co.nambang.product.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.nambang.cart.vo.CartVO;
import co.nambang.common.DataSource;
import co.nambang.product.mapper.ProductMapper;
import co.nambang.product.vo.ProductVO;


public class ProductServiceImpl implements ProductService{
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
  
	@Override
	public List<ProductVO> productList(int page, String kw) {
		// TODO Auto-generated method stub
		return mapper.productList(page, kw);
	}
	
	@Override
	public boolean addCart(CartVO cvo) {
		// TODO Auto-generated method stub
		return mapper.addCart(cvo) == 1;
	}

	@Override
	public int totalCnt() {
		return mapper.totalCnt();
	}

}
