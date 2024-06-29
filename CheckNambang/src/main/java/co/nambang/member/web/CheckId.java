package co.nambang.member.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.nambang.common.Control;
import co.nambang.member.service.MemberService;
import co.nambang.member.service.MemberServiceImpl;

public class CheckId implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 중복확인 클릭시 아이디 중복확인
		MemberService svc = new MemberServiceImpl();
		
		String userId = req.getParameter("userId");
		if(svc.checkId(userId)) { // {"retCode" : "OK"} 중복된 아이디 없음
			resp.getWriter().print("{\"retCode\" : \"OK\"}");
		}else {
			resp.getWriter().print("{\"retCode\" : \"NO\"}"); // 중복된 아이디 있음
		}
		
	}

}
