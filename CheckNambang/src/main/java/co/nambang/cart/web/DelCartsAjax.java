package co.nambang.cart.web;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.nambang.cart.service.CartService;
import co.nambang.cart.service.CartServiceImpl;
import co.nambang.cart.vo.CartNODTO;
import co.nambang.common.Control;

public class DelCartsAjax implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletInputStream sis = req.getInputStream();
		String json = StreamUtils.copyToString(sis, StandardCharsets.UTF_8);
		System.out.println(json);
		req.getParameter("id");
		// 12,13,14 ${param} 문자열 그대로 들어감.
		// 문자열 -> 객체
		ObjectMapper objectMapper = new ObjectMapper();
		CartNODTO centers = objectMapper.readValue(json, CartNODTO.class);
		System.out.println(centers);
		
		CartService csvc = new CartServiceImpl();
		if(csvc.delCarts(centers.getDelCarts())) {
			Gson gson = new GsonBuilder().create();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("retCode", "OK");
			
			String json2 = gson.toJson(map);
			resp.getWriter().print(json2);
		}
		
	}

}
