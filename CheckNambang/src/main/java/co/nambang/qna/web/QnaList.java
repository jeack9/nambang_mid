package co.nambang.qna.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.nambang.common.Control;
import co.nambang.member.vo.MemberVO;
import co.nambang.qna.service.QnaService;
import co.nambang.qna.service.QnaServiceImpl;
import co.nambang.qna.vo.PageDTO;
import co.nambang.qna.vo.QnaVO;

public class QnaList implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		MemberVO login = (MemberVO) session.getAttribute("login");
		
		if(login != null) req.getRequestDispatcher("board/qnaList.tiles").forward(req, resp);
		else {
			req.setAttribute("msg", "로그인해라.");
			req.getRequestDispatcher("loginForm.do").forward(req, resp);
		}
	}

}
