package co.nambang.cart.service;

import co.nambang.cart.vo.CartVO;

public interface CartService {
	public boolean addCart(CartVO cvo);
	public boolean checkCart(CartVO cvo);
	public boolean updateCart(CartVO cvo);
}
