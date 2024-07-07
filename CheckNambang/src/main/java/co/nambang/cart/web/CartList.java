package co.nambang.cart.web;

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
import co.nambang.common.Control;
import co.nambang.member.vo.MemberVO;

public class CartList implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		MemberVO login = (MemberVO)session.getAttribute("login");
		String userId = login == null ? "" : login.getUserId();
		
		CartService csvc = new CartServiceImpl();
		List<Map<String, Object>> cartList = csvc.cartList(userId);
		req.setAttribute("cartList", cartList);// 카트 정보
		
		AddrService asvc = new AddrServiceImpl();
		AddrVO avo = asvc.getAddrPick(userId);
		req.setAttribute("addr", avo);
		
		req.getRequestDispatcher("cart/cartList.tiles").forward(req, resp);
	}

}
