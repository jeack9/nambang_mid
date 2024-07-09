package co.nambang.qna.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.nambang.common.Control;
import co.nambang.qna.service.QnaService;
import co.nambang.qna.service.QnaServiceImpl;
import co.nambang.qna.vo.QnaVO;

public class ViewQna implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String no = req.getParameter("no");
		QnaService qsvc = new QnaServiceImpl();
		QnaVO qvo = qsvc.getQna(Integer.parseInt(no));
		req.setAttribute("qna", qvo);
		
		req.getRequestDispatcher("board/qnaView.tiles").forward(req, resp);
	}	

}
