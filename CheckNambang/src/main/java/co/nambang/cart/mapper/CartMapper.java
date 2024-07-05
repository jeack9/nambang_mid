package co.nambang.cart.mapper;

import java.util.List;
import java.util.Map;

import co.nambang.cart.vo.CartVO;

public interface CartMapper {
	public int addCart(CartVO cvo); // 장바구니 등록

	public int selectCart(CartVO cvo); // userId와 productCode로 등록된 카트 조회
	
	public int updateCart(CartVO cvo); // 카트 업데이트
	
	public List<Map<String, Object>> cartList(String uid); // 유저에 따른 카트리스트 조회
	
	public CartVO getCart(int cartNo); // 한 개의 카트 정보 조회
	
	public int editCart(CartVO cvo); // 카트의 볼륨 변경
}
