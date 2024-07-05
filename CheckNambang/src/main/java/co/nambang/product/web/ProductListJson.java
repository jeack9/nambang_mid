package co.nambang.product.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.nambang.common.Control;
import co.nambang.product.service.ProductService;
import co.nambang.product.service.ProductServiceImpl;
import co.nambang.product.vo.ProductVO;

public class ProductListJson implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String page = req.getParameter("page");
		String kw = req.getParameter("kw");

		page = page == null ? "1" : page; // 페이지값이 null 이면 1페이지를 보여줌
		kw = kw == null ? "" : kw;
		// 목록
		ProductService svc = new ProductServiceImpl();
		List<ProductVO> list = svc.productList(Integer.parseInt(page), kw);

		Gson gson = new GsonBuilder().setPrettyPrinting().create(); // gson 라이브러리 부르기
		String json = gson.toJson(list); // 객체를 문자열로 변경하는 메소드 toJson

		resp.getWriter().print(json); // 출력

	}

}
