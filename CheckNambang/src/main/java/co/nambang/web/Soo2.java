package co.nambang.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.nambang.common.Control;
import co.nambang.notice.service.NoticeService;
import co.nambang.notice.service.NoticeServiceImpl;
import co.nambang.notice.vo.NoticeVO;


public class Soo2 implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/json;charset=utf-8");
		
		int no = Integer.parseInt(req.getParameter("no"));
		
		NoticeService scv = new NoticeServiceImpl();
		List<NoticeVO> list = scv.noticeList2(no);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create(); //gson 객체생성(외워)
		String json = gson.toJson(list);//객체-> 문자열
		//{"test":"a"} => json
		//{ test :"a"} => 객체
		resp.getWriter().print(json);//사용자 웹브라우저 출력
	}

}
