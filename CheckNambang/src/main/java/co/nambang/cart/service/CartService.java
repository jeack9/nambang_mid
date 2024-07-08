package co.nambang.cart.service;

import java.util.List;
import java.util.Map;

import co.nambang.cart.vo.CartVO;

public interface CartService {
	public boolean addCart(CartVO cvo);
	public boolean checkCart(CartVO cvo);
	public boolean updateCart(CartVO cvo);
	public List<Map<String, Object>> cartList(String userId);
	public CartVO getCart(int cartNo);
	public boolean editCart(CartVO cvo);
	public boolean removeCart(int cartNo);
	
	public boolean delCarts(int[] cartNoArr);
	public List<Map<String, Object>> orderCarts(int[] arr);
	
	public int cartCnt(String userId);
}
