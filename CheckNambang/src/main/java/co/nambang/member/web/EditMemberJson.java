package co.nambang.member.web;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.nambang.common.Control;
import co.nambang.member.vo.MemberVO;
import co.nambang.mypage.service.mypageService;
import co.nambang.mypage.service.mypageServiceImpl;
import co.nambang.mypage.vo.mypageVO;

public class EditMemberJson implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		MemberVO login = (MemberVO) session.getAttribute("login");
		String userId = login == null ? "" : login.getUserId();

		String userPw = req.getParameter("userPw");
		String userName = req.getParameter("userName");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String gender = req.getParameter("gender");
		DateFormat datefm = new SimpleDateFormat("yyyyMMdd");
		Date birth = null;

		mypageVO mvo = new mypageVO();

		mvo.setUserId(userId);
		mvo.setUserPw(userPw);
		mvo.setUserName(userName);
		mvo.setEmail(email);
		mvo.setPhone(phone);
		mvo.setGender(gender);

		try {
			java.util.Date parsedDate = datefm.parse(req.getParameter("birthYear"));
			birth = new Date(parsedDate.getTime());
			mvo.setBirth(birth);
			System.out.println(birth);
		} catch (Exception e) {
			e.printStackTrace();
		}

		mypageService svc = new mypageServiceImpl();

		if (svc.modifyMember(mvo)) {
			resp.sendRedirect("myPageForm.do");
		} else {
			resp.getWriter().print("{\"retCode\" : \"Bad\", \"retMsg\": \"Lose\"}");
		}
	}

}
