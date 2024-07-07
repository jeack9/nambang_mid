package co.nambang.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.nambang.common.Control;

public class Woon11 implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(req.getParameter("mode").equals("1")) {
			req.getRequestDispatcher("WEB-INF/view/mypage/address2.jsp").forward(req, resp);
		}else {
			req.getRequestDispatcher("mypage/address.tiles").forward(req, resp);
		}
	}

}
