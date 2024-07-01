package co.nambang.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.nambang.common.Control;
import co.nambang.odproduct.service.OdProductService;
import co.nambang.odproduct.service.OdProductServiceImpl;
import co.nambang.odproduct.vo.OdProductVO;

public class Woon10 implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int orderNo = Integer.parseInt(req.getParameter("orderNo"));
		
		OdProductVO ovo = new OdProductVO();
				
		OdProductService svc = new OdProductServiceImpl();
		
		List<OdProductVO> list = svc.orderHistoryList(orderNo);
		
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(list);
		resp.getWriter().print(json);
	}

}
