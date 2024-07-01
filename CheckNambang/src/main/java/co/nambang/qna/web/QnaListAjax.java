package co.nambang.qna.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.nambang.common.Control;
import co.nambang.member.vo.MemberVO;
import co.nambang.qna.service.QnaService;
import co.nambang.qna.service.QnaServiceImpl;
import co.nambang.qna.vo.PageDTO;
import co.nambang.qna.vo.QnaVO;
import co.nambang.qna.vo.SearchVO;

public class QnaListAjax implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String page = req.getParameter("page");
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		
		HttpSession session = req.getSession();
		MemberVO login = (MemberVO) session.getAttribute("login");
		String userId = login == null ? "" : login.getUserId();
		
		page = page == null ? "1" : page;
		sc = sc == null ? "0" : sc;
		
		SearchVO search = new SearchVO(Integer.parseInt(page), Integer.parseInt(sc), kw, userId);
		System.out.println(search.toString());
		QnaService svc = new QnaServiceImpl();
		List<QnaVO> list = svc.qnaList(search);
//		req.setAttribute("list", list);
//		req.setAttribute("searchCondition", sc);
//		req.setAttribute("keyword", kw);
		
		int totalCnt = svc.getTotalCnt();
		PageDTO dto = new PageDTO(Integer.parseInt(page), totalCnt);
//		req.setAttribute("paging", dto);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("search", search);
		map.put("paging", dto);
		
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(map);
		
		resp.getWriter().print(json);
	}

}
