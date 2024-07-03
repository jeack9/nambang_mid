package co.nambang.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.nambang.common.Control;
import co.nambang.member.vo.MemberVO;
import co.nambang.mypage.service.mypageService;
import co.nambang.mypage.service.mypageServiceImpl;
import co.nambang.mypage.vo.mypageVO;

public class Woon15 implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = req.getSession();
		MemberVO login = (MemberVO)session.getAttribute("login");
		
		//session.setAttribute("loginPw", login);
		
		String userId = login == null ? "" : login.getUserId();
		
		String userPw = login.getUserPw();
		
		
		mypageVO mvo = new mypageVO();
		mvo.setUserId(userId);
		mvo.setUserPw(userPw);
		
		
		Gson gson = new GsonBuilder().create();
		String json =gson.toJson(login);
		resp.getWriter().print(json);
	}

}
