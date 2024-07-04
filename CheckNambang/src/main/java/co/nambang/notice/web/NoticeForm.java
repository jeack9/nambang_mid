package co.nambang.notice.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.nambang.common.Control;

public class NoticeForm implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//클라이언트 요청을 다른자원으로 전달해주는 역할을 함.
		//req.getRequstDispatcher().forward(req,resp);
		req.getRequestDispatcher("board/noticeForm.tiles").forward(req, resp);
	}

}
