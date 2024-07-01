package co.nambang.web;

import java.io.IOException;

import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.nambang.common.Control;
import co.nambang.detail.service.ProDetailService;
import co.nambang.detail.service.ProDetailServiceImpl;

import co.nambang.product.vo.ProductVO;

public class Mo2 implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");
		String productCode = req.getParameter("productCode");
		String userId = req.getParameter("userId");
	
		
		ProDetailService svc = new ProDetailServiceImpl();
		List<ProductVO> list = svc.detailList(productCode);
		
		req.setAttribute("proCode", productCode);
		
		System.out.println(list);
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(list);
		
		resp.getWriter().print(json);
		
		
	}

}
