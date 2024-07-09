package co.nambang.member.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.nambang.cart.service.CartService;
import co.nambang.cart.service.CartServiceImpl;
import co.nambang.common.Control;
import co.nambang.member.service.MemberService;
import co.nambang.member.service.MemberServiceImpl;
import co.nambang.member.vo.MemberVO;
import co.nambang.zzim.service.ZzimService;
import co.nambang.zzim.service.ZzimServiceImpl;

public class LoginMember implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("userId");
		String pw = req.getParameter("userPw");
		
		MemberService svc = new MemberServiceImpl();
		MemberVO mvo = new MemberVO();
		mvo.setUserId(id);
		mvo.setUserPw(pw);
		MemberVO login = svc.login(mvo);
		if(login != null) {
			HttpSession session = req.getSession();
			session.setAttribute("login", login);
	
			
			resp.getWriter().print("{\"retCode\" : \"OK\"}");
		}else {
			resp.getWriter().print("{\"retCode\" : \"NO\"}");
		}
	}

}
