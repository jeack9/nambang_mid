package co.nambang.order.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.nambang.addr.service.AddrService;
import co.nambang.addr.service.AddrServiceImpl;
import co.nambang.addr.vo.AddrVO;
import co.nambang.cart.service.CartService;
import co.nambang.cart.service.CartServiceImpl;
import co.nambang.cart.vo.CartVO;
import co.nambang.common.Control;
import co.nambang.member.vo.MemberVO;

public class OrderForm implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 선택한 카트, 배송지 전달
		String[] carts = req.getParameterValues("cartNo");
		CartService csvc = new CartServiceImpl();
		int[] arr = new int[carts.length];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(carts[i]);
		}
		List<Map<String, Object>> list = csvc.orderCarts(arr);
		req.setAttribute("list", list);
		
		// 선택된 배송지 정보 전달
		AddrService asvc = new AddrServiceImpl();
		HttpSession session = req.getSession();
		MemberVO login = (MemberVO)session.getAttribute("login");
		String userId = login != null ? login.getUserId() : "";
		AddrVO avo = asvc.getAddrPick(userId);
		req.setAttribute("addr", avo);
		
		req.getRequestDispatcher("order/orderForm.tiles").forward(req, resp);
	}

}
