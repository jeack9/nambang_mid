package co.nambang.product.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.nambang.common.Control;
import co.nambang.product.service.ProductService;
import co.nambang.product.service.ProductServiceImpl;
import co.nambang.product.vo.ProductVO;
import co.nambang.product.vo.SearchVO;

public class ProductList implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cate = req.getParameter("cate");
		String chosung = req.getParameter("cho");

		SearchVO svo = new  SearchVO();

		svo.setCategory(cate);
		svo.setBrandChosung(chosung);
		
		ProductService svc = new ProductServiceImpl();
		List<SearchVO> list = svc.cateList(svo);
		List<SearchVO> choList = svc.chosungList(svo);
		List<ProductVO> pvo = svc.viewCntList();
		List<List<ProductVO>> target = new ArrayList<List<ProductVO>>();
		target.add(pvo);
		target.add(pvo);
		target.add(pvo);
		
		
		
		req.setAttribute("category", list);
		req.setAttribute("chosung", choList);
		req.setAttribute("target", target);
		
		req.getRequestDispatcher("product/product.tiles").forward(req, resp);
	}

}
