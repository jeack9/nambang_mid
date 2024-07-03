package co.nambang.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.nambang.common.Control;
import co.nambang.member.vo.MemberVO;
import co.nambang.zzim.service.ZzimService;
import co.nambang.zzim.service.ZzimServiceImpl;
import co.nambang.zzim.vo.ZzimVO;

public class Mo implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req.setAttribute("proCode", req.getParameter("proCode"));
		//String proCode = req.getParameter("procode");
		HttpSession session = req.getSession();
		MemberVO login = (MemberVO)session.getAttribute("login");
		
		String proCode = req.getParameter("proCode");
		if(login != null) {
			ZzimService zsvc = new ZzimServiceImpl();
			List<ZzimVO> zzimList =  zsvc.zzimItems(login.getUserId());
			
			for(ZzimVO vo : zzimList) {
				if(proCode.equals(vo.getProductCode())) {
					req.setAttribute("zzim", true);
				}else{
					req.setAttribute("zzim", false);
				}
			}
		}else if(login == null) {
			req.setAttribute("zzim", false);
		}
		
		req.getRequestDispatcher("detail/productDetail2.tiles").forward(req, resp);

	}

}
