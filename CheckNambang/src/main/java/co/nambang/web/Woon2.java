package co.nambang.web;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

public class Woon2 implements Control {

    @Override
    public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		MemberVO login = (MemberVO)session.getAttribute("login");
		String userId = login == null ? "" : login.getUserId();
       System.out.println(userId);      
       
       mypageService svc = new mypageServiceImpl();
       List<mypageVO> list = svc.mypageView(userId);
       
       Gson gson = new GsonBuilder().setPrettyPrinting().create();	// Gson 생성방식
	   String json = gson.toJson(list);	// 객체 -> 문자열.
		
	   resp.getWriter().print(json);	// 출력
    }
}
