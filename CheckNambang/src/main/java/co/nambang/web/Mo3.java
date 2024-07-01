package co.nambang.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.nambang.common.Control;
import co.nambang.detail.service.ProDetailService;
import co.nambang.detail.service.ProDetailServiceImpl;
import co.nambang.zzim.vo.ZzimVO;

public class Mo3 implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String proCode = req.getParameter("proCode");
		String userId = req.getParameter("userId");
		
		ProDetailService svc = new ProDetailServiceImpl();
		ZzimVO zvo = new ZzimVO();
		zvo.setUserId(userId);
		zvo.setProductCode(userId);
		req.setAttribute("zzim", zvo);
		
		if(svc.insZzim(proCode,userId)) {//{"retCode" : "OK"}
			resp.getWriter().print("{\"retCode\" : \"OK\"}");
		}else {
			resp.getWriter().print("{\"retCode\" : \"NG\"}");
		}
		
		
	}

}
