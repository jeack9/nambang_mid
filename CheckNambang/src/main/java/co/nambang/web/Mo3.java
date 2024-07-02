package co.nambang.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import co.nambang.zzim.vo.ZzimVO;

public class Mo3 implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String proCode = req.getParameter("proCode");
		
		HttpSession session = req.getSession();
		MemberVO login = (MemberVO)session.getAttribute("login");
		String userId = login.getUserId();
		
		ProDetailService svc = new ProDetailServiceImpl();
		ZzimVO zvo = new ZzimVO();
	
		zvo.setProductCode(proCode);
		req.setAttribute("zzim", zvo);
		
//		Map<String, Object> map = new HashMap<String, Object>();
//		
//		ZzimService zsvc = new ZzimServiceImpl();
//		List<ZzimVO> zlist = zsvc.zzimItems(login.getUserId());
//				
//		map.put("zzim", zlist);
		
		if(svc.insZzim(proCode,userId)) {//{"retCode" : "OK"}
			resp.getWriter().print("{\"retCode\" : \"OK\"}");
		}else {
			resp.getWriter().print("{\"retCode\" : \"NG\"}");
		}
		
		
	}

}
