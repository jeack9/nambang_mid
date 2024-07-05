package co.nambang.cart.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.nambang.cart.service.CartService;
import co.nambang.cart.service.CartServiceImpl;
import co.nambang.common.Control;

public class RemoveCartAjax implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cartNo = req.getParameter("cartNo");
		CartService csvc = new CartServiceImpl();
		if(csvc.removeCart(Integer.parseInt(cartNo))) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("retCode", "OK");
			Gson gson = new GsonBuilder().create();
			String json = gson.toJson(map);
			resp.getWriter().print(json);
		}
		
	}

}
