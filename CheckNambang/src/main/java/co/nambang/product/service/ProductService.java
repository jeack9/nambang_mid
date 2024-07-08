package co.nambang.product.service;

import java.util.List;

import co.nambang.cart.vo.CartVO;
import co.nambang.product.vo.ProductVO;
import co.nambang.product.vo.SearchVO;

public interface ProductService {
	List<ProductVO> productList(SearchVO svo);
	boolean addCart(CartVO cvo);
	int totalCnt(SearchVO svo);
	
	ProductVO getProduct(String pno);
}
