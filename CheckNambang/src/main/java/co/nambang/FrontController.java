package co.nambang;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.nambang.common.Control;
import co.nambang.member.web.Test;
import co.nambang.web.Main;

public class FrontController extends HttpServlet {
	private Map<String, Control> map;
	
	public FrontController() {
		map = new HashMap<>();
	}
	
	@Override
	public void init() throws ServletException {
		map.put("/main.do", new Main());
		map.put("/test.do", new Test());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI(); // 서버정보를 뺀 url
		System.out.println("uri: " + uri); // /BoardWeb/main.do
		String context = req.getContextPath(); // project name => /BoardWeb
		System.out.println("context: " + context);
		String page = uri.substring(context.length());
		System.out.println("page: " + page);
		
		Control result = map.get(page);
		result.exec(req, resp);
		System.out.println("result: " + result);
	}
}
