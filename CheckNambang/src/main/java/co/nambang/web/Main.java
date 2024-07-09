package co.nambang.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.nambang.cart.service.CartService;
import co.nambang.cart.service.CartServiceImpl;
import co.nambang.common.Control;
import co.nambang.member.vo.MemberVO;

public class Main implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("productList.do").forward(req, resp);
	}

}
