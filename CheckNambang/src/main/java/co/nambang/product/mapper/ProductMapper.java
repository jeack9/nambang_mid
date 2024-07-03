package co.nambang.product.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.nambang.product.vo.ProductVO;

// 주문내역 테이블
public interface ProductMapper {
	//상품 리스트 조회
	List<ProductVO> productList(@Param("page") int page);
	
}
