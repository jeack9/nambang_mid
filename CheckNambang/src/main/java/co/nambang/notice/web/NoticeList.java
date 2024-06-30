package co.nambang.notice.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.nambang.common.Control;
import co.nambang.common.PageDTO;
import co.nambang.notice.service.NoticeService;
import co.nambang.notice.service.NoticeServiceImpl;
import co.nambang.notice.vo.NoticeVO;

public class NoticeList implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		NoticeService svc = new NoticeServiceImpl();
		String page = req.getParameter("page");
		
		page = page == null ? "1" : page;
		
		int totalCnt = svc.getTotalCnt();
		PageDTO dto = new PageDTO(Integer.parseInt(page), totalCnt);
		
		List<NoticeVO> list = svc.noticeList(Integer.parseInt(page));
		
		req.setAttribute("list", list);
		req.setAttribute("paging", dto);
		
		req.getRequestDispatcher("board/noticeList.tiles").forward(req, resp);
	}

}
