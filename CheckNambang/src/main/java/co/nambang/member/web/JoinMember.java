package co.nambang.member.web;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestParam;

import co.nambang.addr.service.AddrService;
import co.nambang.addr.service.AddrServiceImpl;
import co.nambang.addr.vo.AddrVO;
import co.nambang.common.Control;
import co.nambang.member.service.MemberService;
import co.nambang.member.service.MemberServiceImpl;
import co.nambang.member.vo.MemberVO;

public class JoinMember implements Control {
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 회원가입 : 회원 등록 -> 배송지 정보 등록 -> 회원정보의 배송지 정보 업데이트
		MemberService msvc = new MemberServiceImpl();
		MemberVO mvo = new MemberVO();
		
		// 회원가입 폼의 정보 가져오기
		String userId = req.getParameter("userId");
		String userPw = req.getParameter("userPw");
		String userName = req.getParameter("userName");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String gender = req.getParameter("gender");
		DateFormat datefm = new SimpleDateFormat("yyyy-MM-dd");
		Date birth = null;
		try {
			birth = datefm.parse(req.getParameter("birth"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String addr1 = req.getParameter("addr1");
		String addr2 = req.getParameter("addr2");
		
		mvo.setUserId(userId);
		mvo.setUserPw(userPw);
		mvo.setUserName(userName);
		mvo.setEmail(email);
		mvo.setPhone(phone);
		mvo.setGender(Integer.parseInt(gender));
		mvo.setBirth(birth);
		
		AddrService asvc = new AddrServiceImpl();
		AddrVO avo = new AddrVO();
		avo.setAddr1(addr1);
		avo.setAddr2(addr2);
		avo.setAddrSelected(1); // 회원가입시 입력한 배송지는 기본 배송지
		avo.setGetter(userName);
		avo.setGetterPhone(phone);
		avo.setUserId(userId);
		
		if(msvc.joinMember(mvo)) {// 회원가입 정보 등록
			if(asvc.addAddr(avo)) {// 회원가입 배송지 정보 등록
				resp.sendRedirect("main.do");
				// 회원의 기본배송지 정보 변경
//				avo = asvc.getSelectedAddr(userId, 1);
//				if(msvc.modiAddr(userId, avo.getAddrNo())) { 
//					resp.sendRedirect("main.do");
//				}
			}
		}
	}

}
