package co.nambang.qna.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.nambang.common.Control;
import co.nambang.qna.service.QnaService;
import co.nambang.qna.service.QnaServiceImpl;

public class qnaListAdmin implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		QnaService qsvc = new QnaServiceImpl();
		
		
	}

}
