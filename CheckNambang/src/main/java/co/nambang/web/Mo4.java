package co.nambang.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.nambang.common.Control;
import co.nambang.detail.service.ProDetailService;
import co.nambang.detail.service.ProDetailServiceImpl;
import co.nambang.member.vo.MemberVO;

public class Mo4 implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cartVolume = req.getParameter("cartVolume");
		String proCode = req.getParameter("proCode");
		
		HttpSession session = req.getSession();
		MemberVO login = (MemberVO)session.getAttribute("login");
		
		String userId = login.getUserId();
		
		ProDetailService svc = new ProDetailServiceImpl();
		
		if(svc.insCart(Integer.parseInt(cartVolume), userId, proCode)) {//{"retCode":"OK"}
			resp.getWriter().print("{\"retCode\":\"OK\"}");
		}else {
			resp.getWriter().print("{\"retCode\":\"NG\"}");
		}
	}

}
