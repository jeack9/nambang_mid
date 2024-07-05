package co.nambang.product.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.nambang.cart.vo.CartVO;
import co.nambang.product.vo.ProductVO;

// 주문내역 테이블
public interface ProductMapper {
	//상품 리스트 조회
	public List<ProductVO> productList(@Param("page") int page, @Param("keyword") String kw);
	//장바구니 카드 추가
	public int addCart(CartVO cvo);
	//장바구니 상품 조회(아이디, 상품코드)
	public CartVO selectCart(CartVO cvo);
	// 상품 총 개수
	public int totalCnt();
	// 상품 한개의 정보 조회
	public ProductVO getProduct(String pno);
}
