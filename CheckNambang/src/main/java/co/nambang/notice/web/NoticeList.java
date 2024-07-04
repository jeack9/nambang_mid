package co.nambang.notice.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.nambang.common.Control;
import co.nambang.notice.service.NoticeService;
import co.nambang.notice.service.NoticeServiceImpl;
import co.nambang.notice.vo.NoticeVO;

public class NoticeList implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		NoticeService svc = new NoticeServiceImpl();
		List<NoticeVO> list = svc.noticelist();

		req.setAttribute("list", list);
		req.setAttribute("myName", "홍길동");
		req.getRequestDispatcher("board/noticeList.tiles").forward(req, resp);

	}

}
