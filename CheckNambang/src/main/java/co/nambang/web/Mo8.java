package co.nambang.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.nambang.common.Control;
import co.nambang.detail.service.ProDetailService;
import co.nambang.detail.service.ProDetailServiceImpl;

public class Mo8 implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String proCode= req.getParameter("proCode");
		
		ProDetailService svc = new ProDetailServiceImpl();
		
		int hugiTotal = svc.hugiListCnt(proCode);
		
		resp.getWriter().print(hugiTotal);
	}

}
