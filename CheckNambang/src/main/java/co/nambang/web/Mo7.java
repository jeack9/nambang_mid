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
import co.nambang.zzim.service.ZzimService;
import co.nambang.zzim.service.ZzimServiceImpl;

public class Mo7 implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String proCode = req.getParameter("proCode");
		
		HttpSession session = req.getSession();
		MemberVO login = (MemberVO) session.getAttribute("login");
		String userId = login == null ? "" : login.getUserId();
		System.out.println("loginId : "+userId);
		
		ProDetailService svc = new ProDetailServiceImpl();
		
			if(svc.zzimSelect(proCode,userId)) {//{"retCode":"OK"}
				System.out.println("11111111111111111111111111111");
				resp.getWriter().print("{\"retCode\":\"OK\"}");
				System.out.println("성공");
			}else {
				System.out.println("2222222222222222222222222222");
				resp.getWriter().print("{\"retCode\":\"NG\"}");
				System.out.println("실패");
			}
		
		
	}

}
