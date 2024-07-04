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

public class Woon17 implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		MemberVO login = (MemberVO)session.getAttribute("login");
		String userId = login == null ? "" : login.getUserId();
		
		
		AddrVO avo = new AddrVO();
		avo.setUserId(userId);
		AddrService svc = new AddrServiceImpl();
		svc.basicAddress();
		
		System.out.println(userId);
		
		
		// 0 값으로 변경 먼저 실행 => addrNo 받는것을 다음 으로 실행
		
		int addrNo = Integer.parseInt(req.getParameter("addrNo"));
		avo.setAddrNo(addrNo);
		
		System.out.println(addrNo);
		
		if(svc.changeAddress(addrNo)) {
			resp.sendRedirect("woonControl11.do");
		}else {
			System.out.println("잘못 되었습니다.");
		}
		
	}

}
