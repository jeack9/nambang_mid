package co.nambang.product.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.nambang.common.DataSource;
import co.nambang.product.mapper.ProductMapper;
import co.nambang.product.vo.ProductVO;


public class ProductServiceImpl implements ProductService{
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
  
	@Override
	public List<ProductVO> productList(int page) {
		// TODO Auto-generated method stub
		return mapper.productList(page);
	}
	
	@Override
	public boolean addCart(int volume, String userId, String proCode) {
		// TODO Auto-generated method stub
		return mapper.addCart(volume, userId, proCode) == 1;
	}
}
