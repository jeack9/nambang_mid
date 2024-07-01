package co.nambang.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.nambang.common.Control;
import co.nambang.detail.service.ProDetailService;
import co.nambang.detail.service.ProDetailServiceImpl;

public class Mo4 implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cartVolume = req.getParameter("cartVolume");
		String userId = req.getParameter("userId");
		String proCode = req.getParameter("proCode");
		
		ProDetailService svc = new ProDetailServiceImpl();
		
		if(svc.insCart(Integer.parseInt(cartVolume), userId, proCode)) {//{"retCode":"OK"}
			resp.getWriter().print("{\"retCode\":\"OK\"}");
		}else {
			resp.getWriter().print("{\"retCode\":\"NG\"}");
		}
	}

}
