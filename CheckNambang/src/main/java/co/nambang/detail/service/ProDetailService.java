package co.nambang.detail.service;

import java.util.List;

import co.nambang.detail.vo.ProDetailVO;
import co.nambang.product.vo.ProductVO;

public interface ProDetailService {
	List<ProductVO> detailList(String proCode);
	
	boolean insZzim(String proCode, String userId);
}
