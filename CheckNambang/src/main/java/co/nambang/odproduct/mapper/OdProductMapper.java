package co.nambang.odproduct.mapper;

import java.util.List;

import co.nambang.odproduct.vo.OdProductVO;

// 주문상세
public interface OdProductMapper {	
	List<OdProductVO> orderHistory(int orderNo);
	
	public int addOdProducts(OdProductVO[] arrVO);
}
