package co.nambang.product.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.nambang.cart.vo.CartVO;
import co.nambang.common.DataSource;
import co.nambang.product.mapper.ProductMapper;
import co.nambang.product.vo.ProductVO;
import co.nambang.product.vo.SearchVO;


public class ProductServiceImpl implements ProductService{
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
  
	@Override
	public List<ProductVO> productList(SearchVO svo) {
		// TODO Auto-generated method stub
		return mapper.productList(svo);
	}
	
	@Override
	public boolean addCart(CartVO cvo) {
		// TODO Auto-generated method stub
		return mapper.addCart(cvo) == 1;
	}

	@Override
	public int totalCnt(SearchVO svo) {
		return mapper.totalCnt(svo);
	}
	
	@Override
	public ProductVO getProduct(String pno) {
		return mapper.getProduct(pno);
	}

	@Override
	public List<SearchVO> cateList(SearchVO svo) {
		// TODO Auto-generated method stub
		return mapper.cateList(svo);
	}

	@Override
	public List<SearchVO> chosungList(SearchVO svo) {
		// TODO Auto-generated method stub
		return mapper.chosungList(svo);
	}

	@Override
	public List<ProductVO> viewCntList() {
		// TODO Auto-generated method stub
		return mapper.viewCntList();
	}



}
