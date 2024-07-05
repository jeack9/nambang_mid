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
import co.nambang.cart.vo.CartVO;
import co.nambang.common.Control;
import co.nambang.product.service.ProductService;
import co.nambang.product.service.ProductServiceImpl;
import co.nambang.product.vo.ProductVO;

public class EditCartAjax implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 카트 + - 눌렀을때 현 유저의 카트 업데이트 volume, cart_no 정보 필요
		String cartNo = req.getParameter("cartNo");
		String volume = req.getParameter("volume");
		
		CartService csvc = new CartServiceImpl();
		CartVO cvo = new CartVO();
		cvo.setCartNo(Integer.parseInt(cartNo));
		cvo.setCartVolume(Integer.parseInt(volume));
		
		Map<String, Object> map = new HashMap<String, Object>();
		Gson gson = new GsonBuilder().create();
		
		try {
			if(csvc.editCart(cvo)) {
				cvo = csvc.getCart(Integer.parseInt(cartNo));
				ProductService psvc = new ProductServiceImpl();
				ProductVO pvo = psvc.getProduct(Integer.parseInt(cartNo));
				map.put("cart", cvo);
				map.put("product", pvo);
				map.put("retCode", "OK");
				String json = gson.toJson(map);
				resp.getWriter().print(json);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
