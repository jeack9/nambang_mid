package co.nambang.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.nambang.common.Control;
import co.nambang.detail.service.ProDetailService;
import co.nambang.detail.service.ProDetailServiceImpl;
import co.nambang.member.vo.MemberVO;
import co.nambang.product.vo.ProductVO;
import co.nambang.zzim.service.ZzimService;
import co.nambang.zzim.service.ZzimServiceImpl;
import co.nambang.zzim.vo.ZzimVO;

public class Mo2 implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");
		String proCode = req.getParameter("proCode");
		HttpSession session = req.getSession();
		MemberVO login = (MemberVO)session.getAttribute("login");
		
		
		ProDetailService svc = new ProDetailServiceImpl();
		List<ProductVO> list = svc.detailList(proCode);
		req.setAttribute("proCode", proCode);
		
		Map<String, Object> map = new HashMap<String, Object>(); // 선택한 상품vo, 로그인한 유저의 찜목록
		map.put("product", list);
		map.put("proCode", proCode);
		if(login != null) {
			
			ZzimService zsvc = new ZzimServiceImpl();
			List<ZzimVO> zlist = zsvc.zzimItems(login.getUserId());
			
			map.put("zzim", zlist);
		}
		
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(map);
		
		resp.getWriter().print(json);
				
	}

}
