package co.nambang.qna.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.nambang.common.Control;
import co.nambang.qna.service.QnaService;
import co.nambang.qna.service.QnaServiceImpl;

public class RemoveQna implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String no = req.getParameter("no");
		System.out.println(no);
		QnaService qsvc = new QnaServiceImpl();
		if(qsvc.removeQna(Integer.parseInt(no))) {
			resp.sendRedirect("qnaList.do");
		}
	}

}
