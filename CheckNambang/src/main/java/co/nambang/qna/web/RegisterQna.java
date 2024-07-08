package co.nambang.qna.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.nambang.common.Control;
import co.nambang.member.vo.MemberVO;
import co.nambang.qna.service.QnaService;
import co.nambang.qna.service.QnaServiceImpl;
import co.nambang.qna.vo.QnaVO;

public class RegisterQna implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 파일첨부일 경우에는 multipart 요청을 처리.
		// Multipart 요청(1.요청정보, 2.저장위치, 3.최대크기, 4.인코딩방식, 5.리네임정책)
		String savePath = req.getServletContext().getRealPath("qnaImage");
		int maxSize = 1024 * 1024 * 5; // 5mb
		String encoding = "utf-8";
		System.out.println(savePath + "세이브패스");
		MultipartRequest mr = new MultipartRequest(req, savePath, maxSize, encoding, new DefaultFileRenamePolicy());
		
		String orderNo = mr.getParameter("orderNo"); 
		String type1 = mr.getParameter("type1"); 
		String type2 = mr.getParameter("type2");
		String title = mr.getParameter("title");
		String content = mr.getParameter("content");
		String image = mr.getFilesystemName("image");
		System.out.println(image);
		System.out.println("이미징미지이미지");
		orderNo = orderNo.equals("") ? "-1" : orderNo;
		HttpSession session = req.getSession();
		MemberVO login = (MemberVO)session.getAttribute("login");
		String userId = login == null ? "" : login.getUserId();
		
		QnaVO qna = new QnaVO();
		qna.setOrderNo(Integer.parseInt(orderNo));
		qna.setQnaType1(type1);
		qna.setQnaType2(type2);
		qna.setQnaTitle(title);
		qna.setQnaContent(content);
		qna.setQnaImage(image);
		qna.setUserId(userId);
		
		QnaService qsvc = new QnaServiceImpl();
		
		try {
			if(qsvc.registerQna(qna)) { // qna 등록 성공
				resp.sendRedirect("qnaList.do");
			}
		} catch (Exception e) {
			req.setAttribute("err", "에러");
			req.getRequestDispatcher("main.do").forward(req, resp);
		}
	}

}
