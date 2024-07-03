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
		String sc = req.getParameter("sc");
		String kw = req.getParameter("kw");
		
		HttpSession session = req.getSession();
		MemberVO login = (MemberVO) session.getAttribute("login");
		String userId = login == null ? "" : login.getUserId();
		
		
		SearchVO search = new SearchVO();
		search.setPage(Integer.parseInt(page));
		search.setKeyword(kw);
		search.setUserId(userId);
		search.setSearchCondition(Integer.parseInt(sc));
		System.out.println(search);

		QnaService svc = new QnaServiceImpl();
		int totalCnt = svc.getTotalCnt(search);
		
		List<QnaVO> list = svc.qnaList(search);
		PageDTO dto = new PageDTO(Integer.parseInt(page), totalCnt);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("search", search);
		map.put("paging", dto);
		
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(map);
		
		resp.getWriter().print(json);
	}

}
