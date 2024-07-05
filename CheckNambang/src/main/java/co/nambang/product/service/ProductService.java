package co.nambang.product.service;

import java.util.List;

import co.nambang.cart.vo.CartVO;
import co.nambang.product.vo.ProductVO;

public interface ProductService {
	List<ProductVO> productList(int page, String kw);
	boolean addCart(CartVO cvo);
	int totalCnt();
	
	ProductVO getProduct(String pno);
}
