package co.nambang.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.nambang.common.Control;
import co.nambang.zzim.service.ZzimService;
import co.nambang.zzim.service.ZzimServiceImpl;
import co.nambang.zzim.vo.ZzimVO;

public class Woon8 implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String productCode = req.getParameter("productCode");
		ZzimVO zvo = new ZzimVO();
		
		ZzimService svc = new ZzimServiceImpl();
		if(svc.deleteZzimItems(productCode)) {
			resp.sendRedirect("woonControl6.do");
		}
	}

}
