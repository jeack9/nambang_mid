package co.nambang.web;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.nambang.common.Control;
import co.nambang.mypage.service.mypageService;
import co.nambang.mypage.service.mypageServiceImpl;
import co.nambang.mypage.vo.mypageVO;

public class Woon2 implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String newUserPw = req.getParameter("newUserPw");
		String userName = req.getParameter("userName");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String gender = req.getParameter("gender");
		
		mypageVO mvo = new mypageVO();
		
		mvo.setUserPw(newUserPw);
		mvo.setUserName(userName);
		mvo.setEmail(email);
		mvo.setPhone(phone);
		mvo.setGender(gender);
		
		mypageService svc = new mypageServiceImpl();
		
		if(svc.modifyMember(mvo)) {
			resp.getWriter().print("{\"retCode\" : \"Good\", \"retMsg\": \"Win\"}");
		}else {
			resp.getWriter().print("{\"retCode\" : \"Bad\", \"retMsg\": \"Lose\"}");
		}		
		
	}

}
