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
import co.nambang.web.Hyun;
import co.nambang.web.Hyun2;
import co.nambang.web.Main;
import co.nambang.web.Mo;
import co.nambang.web.Mo2;
import co.nambang.web.Soo;
import co.nambang.web.Soo2;
import co.nambang.web.Woon;
import co.nambang.web.Woon2;

public class FrontController extends HttpServlet {
	private Map<String, Control> map;
	
	public FrontController() {
		map = new HashMap<>();
	}
	
	@Override
	public void init() throws ServletException {
		map.put("/main.do", new Main());
		map.put("/test.do", new Test());
		
		// 안준모의 테스트 컨트롤러
		map.put("/mocontrol.do", new Mo());
		map.put("/mocontrol2.do", new Mo2());
		// 김대운의 테스트 컨트롤러
		map.put("/woonControl.do", new Woon());
		map.put("/woonControl2.do", new Woon2());
		// 이상현의 테스트 컨트롤러
		map.put("/hyunControl.do", new Hyun());
		map.put("/hyunControl2.do", new Hyun2());
		// 김지수의 테스트 컨트롤러
		map.put("/sooControl.do", new Soo());
		map.put("/sooControl2.do", new Soo2());
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
