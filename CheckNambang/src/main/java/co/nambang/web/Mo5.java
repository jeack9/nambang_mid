package co.nambang.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.nambang.common.Control;
import co.nambang.detail.service.ProDetailService;
import co.nambang.detail.service.ProDetailServiceImpl;
import co.nambang.hugi.vo.HugiVO;
import co.nambang.member.service.MemberService;
import co.nambang.member.service.MemberServiceImpl;

public class Mo5 implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String proCode = req.getParameter("proCode");
		
		ProDetailService svc = new ProDetailServiceImpl();
		List<HugiVO> list = svc.detailHugi(proCode);
		
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(list);
		
		resp.getWriter().print(json);
	}

}
