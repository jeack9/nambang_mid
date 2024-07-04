package co.nambang.qna.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.nambang.common.Control;
import co.nambang.qna.service.QnaService;
import co.nambang.qna.service.QnaServiceImpl;

public class Type2 implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String type1 = req.getParameter("type1");
		
		QnaService svc = new QnaServiceImpl();
		List<String> types2 = svc.type2List(type1);
		
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(types2);
		
		resp.getWriter().print(json);
	}

}
