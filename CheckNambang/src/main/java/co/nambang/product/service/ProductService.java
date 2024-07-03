package co.nambang.product.service;

import java.util.List;

import co.nambang.product.vo.ProductVO;

public interface ProductService {
	List<ProductVO> productList(int page);
	boolean addCart(int volume, String userId, String proCode);
}
