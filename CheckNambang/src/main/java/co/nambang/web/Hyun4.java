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

public class Hyun4 implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String proCode = req.getParameter("proCode");
	    
		ProDetailService psv = new ProDetailServiceImpl();
		if(psv.detailList(proCode) != null) {
			
		req.getRequestDispatcher("detail/productDetail2.tiles").forward(req, resp);
		}
	}
}
