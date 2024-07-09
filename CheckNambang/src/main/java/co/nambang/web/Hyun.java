package co.nambang.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.nambang.common.Control;
import co.nambang.product.service.ProductService;
import co.nambang.product.service.ProductServiceImpl;
import co.nambang.product.vo.SearchVO;

public class Hyun implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		req.getRequestDispatcher("product/product.tiles").forward(req, resp);
		
		
		
	}

}
