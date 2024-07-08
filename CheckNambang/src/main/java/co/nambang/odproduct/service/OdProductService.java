package co.nambang.odproduct.service;

import java.util.List;

import co.nambang.odproduct.vo.OdProductVO;

public interface OdProductService {
	List<OdProductVO> orderHistoryList(int orderNo);
	int addOdProducts(OdProductVO[] arr);
}
