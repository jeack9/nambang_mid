package co.nambang.detail.mapper;

import java.util.List;

import co.nambang.detail.vo.ProDetailVO;
import co.nambang.product.vo.ProductVO;

public interface ProDetailMapper {
	List<ProductVO> selectList(String productCode);
}
