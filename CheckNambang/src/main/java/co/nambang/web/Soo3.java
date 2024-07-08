package co.nambang.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.nambang.common.Control;
import co.nambang.notice.service.NoticeService;
import co.nambang.notice.service.NoticeServiceImpl;
import co.nambang.notice.vo.NoticeVO;

public class Soo3 implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
         req.setCharacterEncoding("UTF-8");
         
         NoticeVO no = new NoticeVO();
         no.setNoticeTitle(req.getParameter("title"));
         no.setNoticeWriter(req.getParameter("writer"));
         no.setNoticeContent(req.getParameter("content"));
         
         NoticeService svc = new NoticeServiceImpl();
         
         if(svc.addNotice(no)) {
        	 System.out.println("정상적으로 등록되었습니다.");
        	 resp.sendRedirect("noticeList.do");
         }else {
        	 System.out.println("등록 실패하였습니다. 재시도 해주세요.");
        	 req.setAttribute("message","처리중 오류 발생");
        	 req.getRequestDispatcher("WEB-INF/view/board/createNotice").forward(req, resp);
         }
	}

}

