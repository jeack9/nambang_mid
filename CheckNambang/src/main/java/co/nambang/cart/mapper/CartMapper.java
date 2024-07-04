package co.nambang.cart.mapper;

import co.nambang.cart.vo.CartVO;

public interface CartMapper {
	public int addCart(CartVO cvo); // 장바구니 등록

	public int selectCart(CartVO cvo); // userId와 productCode로 등록된 카트 조회
	
	public int updateCart(CartVO cvo); // 카트 업데이트
}
