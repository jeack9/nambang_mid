package co.nambang.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.nambang.addr.service.AddrService;
import co.nambang.addr.service.AddrServiceImpl;
import co.nambang.addr.vo.AddrVO;
import co.nambang.common.Control;
import co.nambang.member.vo.MemberVO;

public class Woon13 implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//HttpSession session = req.getSession();
		//MemberVO login = (MemberVO)session.getAttribute("login");
		//String userId = login == null ? "" : login.getUserId();
		
		String userId = req.getParameter("userId");
		String addr2 = req.getParameter("addr2");
		String getter = req.getParameter("getter");
		String getterPhone = req.getParameter("getterPhone");
		
		AddrVO avo = new AddrVO();
		
		avo.setUserId(userId);
		avo.setAddr2(userId);
		avo.setGetter(getterPhone);
		avo.setGetterPhone(getterPhone);
		
		AddrService svc = new AddrServiceImpl();
		
		if(svc.updateAddr(avo)) {
			resp.getWriter().print("{\"retCode\" : \"Good\", \"retMsg\": \"Win\"}");
		}else {
			resp.getWriter().print("{\"retCode\" : \"Bad\", \"retMsg\": \"Lose\"}");
		}
	}

}
