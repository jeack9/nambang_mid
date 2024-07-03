package co.nambang.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.nambang.common.Control;
import co.nambang.member.vo.MemberVO;
import co.nambang.product.service.ProductService;
import co.nambang.product.service.ProductServiceImpl;

public class Hyun3 implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cartVolume = req.getParameter("cartVolume");
		String proCode = req.getParameter("proCode");
		
		HttpSession session = req.getSession();
	    MemberVO login = (MemberVO)session.getAttribute("login");
	      
	    String userId = login.getUserId();

		ProductService svc = new ProductServiceImpl();

		if (svc.addCart(Integer.parseInt(cartVolume), userId, proCode)) {// {"retCode":"OK"}
			resp.getWriter().print("{\"retCode\":\"OK\"}");
		} else {
			resp.getWriter().print("{\"retCode\":\"NG\"}");
		}
	}

}
