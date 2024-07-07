package co.nambang.order.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.nambang.cart.service.CartService;
import co.nambang.cart.service.CartServiceImpl;
import co.nambang.common.Control;

public class OrderForm implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] carts = req.getParameterValues("cartNo");
		CartService csvc = new CartServiceImpl();
		
		for(String cartNo : carts) {
			
		}
	}

}
