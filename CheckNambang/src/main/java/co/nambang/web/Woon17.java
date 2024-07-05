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
		System.out.println(userId);
		
		AddrService svc = new AddrServiceImpl();
		try {
			if(svc.basicAddress(userId)) {
				System.out.println("0으로 변경이 완료 되었습니다");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error 가 발생 하였습니다");
		}
		
		// 0 값으로 변경 먼저 실행 => addrNo 받는것을 다음 으로 실행
	  
		int addrNo = Integer.parseInt(req.getParameter("addrNo"));

		System.out.println(addrNo);

		avo.setAddrNo(addrNo);

		avo.setAddrSelected(1);

		

		  if(svc.changeAddress(avo)) {
	  
		 resp.getWriter().print("{\"retCode\" : \"Good\", \"retMsg\": \"Win\"}");
		 }else {  
		  resp.getWriter().print("{\"retCode\" : \"Bad\", \"retMsg\": \"Lose\"}"); 
		  }	
	}

}
