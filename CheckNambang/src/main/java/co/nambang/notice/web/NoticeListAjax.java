package co.nambang.notice.web;

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
import co.nambang.common.PageDTO;
import co.nambang.common.SearchVO;
import co.nambang.notice.service.NoticeService;
import co.nambang.notice.service.NoticeServiceImpl;
import co.nambang.notice.vo.NoticeVO;

public class NoticeListAjax implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String page = req.getParameter("page");
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		
		page = page == null ? "1" : page;
		
		SearchVO search = new SearchVO(Integer.parseInt(page), sc, kw);
		
		NoticeService svc = new NoticeServiceImpl();
		List<NoticeVO> list = svc.noticeList(search);
		req.setAttribute("list", list);
		req.setAttribute("searchCondition", sc);
		req.setAttribute("keyword", kw);
		
		int totalCnt = svc.getTotalCnt();
		PageDTO dto = new PageDTO(Integer.parseInt(page), totalCnt);
		req.setAttribute("paging", dto);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("search", search);
		map.put("paging", dto);
		
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(map);
		
		resp.getWriter().print(json);
	}

}
