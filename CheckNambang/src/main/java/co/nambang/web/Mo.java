package co.nambang.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.nambang.common.Control;

public class Mo implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req.setAttribute("proCode", req.getParameter("proCode"));
		
		req.getRequestDispatcher("detail/productDetail2.tiles").forward(req, resp);

	}

}
