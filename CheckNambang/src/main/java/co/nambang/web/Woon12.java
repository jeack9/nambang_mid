package co.nambang.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.nambang.addr.service.AddrService;
import co.nambang.addr.service.AddrServiceImpl;
import co.nambang.addr.vo.AddrVO;
import co.nambang.common.Control;

public class Woon12 implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String addr1 = req.getParameter("addr1");
		String addr2 = req.getParameter("addr2");
		String getter = req.getParameter("getter");
		String getterPhone = req.getParameter("getterPhone");
		String userId = req.getParameter("userId");
		
		System.out.println(addr1);
		System.out.println(addr2);
		System.out.println(getter);
		System.out.println(getterPhone);
		System.out.println(userId);
		
		
		AddrVO avo = new AddrVO();
		
		avo.setAddr1(addr1);
		avo.setAddr2(addr2);
		avo.setGetter(getter);
		avo.setGetterPhone(getterPhone);
		avo.setUserId(userId);
		
		AddrService svc = new AddrServiceImpl();
		
		if(svc.addAddr(avo)) {
			if(req.getParameter("mode").equals("1")) req.getRequestDispatcher("woonControl11.do?mode=1").forward(req, resp);
			else resp.sendRedirect("main.do");		
		}				
	}

}
