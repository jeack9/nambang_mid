package co.nambang.cart.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.nambang.cart.service.CartService;
import co.nambang.cart.service.CartServiceImpl;
import co.nambang.cart.vo.CartVO;
import co.nambang.common.Control;
import co.nambang.member.vo.MemberVO;
import co.nambang.product.service.ProductService;
import co.nambang.product.service.ProductServiceImpl;

public class AddCartAjax implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cartVolume = req.getParameter("cartVolume");
		String proCode = req.getParameter("proCode");
		
		HttpSession session = req.getSession();
	    MemberVO login = (MemberVO)session.getAttribute("login");
	    String userId = login == null ? "" : login.getUserId();

	    CartVO cvo = new CartVO();
	    cvo.setCartVolume(Integer.parseInt(cartVolume));
	    cvo.setProductCode(proCode);
	    cvo.setUserId(userId);
	    System.out.println("2222");
	    System.out.println(cvo.toString());
		ProductService svc = new ProductServiceImpl();
		//카트안에 갯수 체크 및 업데이트
		CartService csvc = new CartServiceImpl();
		
	
		
		if (csvc.checkCart(cvo)) {
			if(csvc.updateCart(cvo)) {
				resp.getWriter().print("{\"retCode\":\"OK\"}");
			} else {
				resp.getWriter().print("{\"retCode\":\"NG\"}");
			}
		}else {
			if (svc.addCart(cvo)) {// {"retCode":"OK"}
				resp.getWriter().print("{\"retCode\":\"OK\"}");
			} else {
				resp.getWriter().print("{\"retCode\":\"NG\"}");
			}
		}

	}

}
