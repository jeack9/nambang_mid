package co.nambang.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.nambang.common.Control;
import co.nambang.product.service.ProductService;
import co.nambang.product.service.ProductServiceImpl;
import co.nambang.product.vo.PageDTO;
import co.nambang.product.vo.ProductVO;
import co.nambang.product.vo.SearchVO;


public class Hyun2 implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String page = req.getParameter("page");
		String kw = req.getParameter("kw");
		 
		
		page = page == null ? "1" : page; // 페이지값이 null 이면 1페이지를 보여줌
		kw = kw == null ? "" : kw ; // 키워드가 null인 경우 빈 공간  
		//목록
		ProductService svc = new ProductServiceImpl();
		List<ProductVO> list = svc.productList(Integer.parseInt(page), kw);
		
		// 페이징 처리를 위한 페이지에 대한 정보
		int totalCnt = svc.totalCnt();
		PageDTO dto = new PageDTO(Integer.parseInt(page), totalCnt);
		
		SearchVO svo = new SearchVO();
		svo.setKeyword(kw);
		 
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("dto", dto);
		map.put("pvd", svo);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create(); // gson 라이브러리 부르기
		String json = gson.toJson(map);  // 객체를 문자열로 변경하는 메소드 toJson
		
		resp.getWriter().print(json); // 출력
		
		
		//페이지 계산
		
		
	}

}


