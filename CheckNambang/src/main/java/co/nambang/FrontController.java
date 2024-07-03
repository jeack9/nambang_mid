package co.nambang;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.nambang.common.Control;
import co.nambang.member.web.CheckId;
import co.nambang.member.web.JoinForm;
import co.nambang.member.web.JoinMember;
import co.nambang.member.web.LoginForm;
import co.nambang.member.web.LoginMember;
import co.nambang.member.web.Logout;
import co.nambang.member.web.Test;
import co.nambang.notice.web.NoticeForm;
import co.nambang.notice.web.NoticeList;
import co.nambang.qna.web.QnaList;
import co.nambang.qna.web.QnaListAjax;
import co.nambang.web.Hyun;
import co.nambang.web.Hyun10;
import co.nambang.web.Hyun2;
import co.nambang.web.Hyun3;
import co.nambang.web.Hyun4;
import co.nambang.web.Hyun5;
import co.nambang.web.Hyun6;
import co.nambang.web.Hyun7;
import co.nambang.web.Hyun8;
import co.nambang.web.Hyun9;
import co.nambang.web.Main;
import co.nambang.web.Mo;
import co.nambang.web.Mo10;
import co.nambang.web.Mo2;
import co.nambang.web.Mo3;
import co.nambang.web.Mo4;
import co.nambang.web.Mo5;
import co.nambang.web.Mo6;
import co.nambang.web.Mo7;
import co.nambang.web.Mo8;
import co.nambang.web.Mo9;
import co.nambang.web.Soo;
import co.nambang.web.Soo10;
import co.nambang.web.Soo2;
import co.nambang.web.Soo3;
import co.nambang.web.Soo4;
import co.nambang.web.Soo5;
import co.nambang.web.Soo6;
import co.nambang.web.Soo7;
import co.nambang.web.Soo8;
import co.nambang.web.Soo9;
import co.nambang.web.Woon;
import co.nambang.web.Woon10;
import co.nambang.web.Woon11;
import co.nambang.web.Woon12;
import co.nambang.web.Woon13;
import co.nambang.web.Woon14;
import co.nambang.web.Woon15;
import co.nambang.web.Woon16;
import co.nambang.web.Woon17;
import co.nambang.web.Woon2;
import co.nambang.web.Woon3;
import co.nambang.web.Woon4;
import co.nambang.web.Woon5;
import co.nambang.web.Woon6;
import co.nambang.web.Woon7;
import co.nambang.web.Woon8;
import co.nambang.web.Woon9;

public class FrontController extends HttpServlet {
	private Map<String, Control> map;
	
	public FrontController() {
		map = new HashMap<>();
	}
	
	@Override
	public void init() throws ServletException {
		map.put("/main.do", new Main());
		map.put("/test.do", new Test());
		
		// 회원관련
		map.put("/joinMemberForm.do", new JoinForm()); // 회원가입 폼
		map.put("/joinMember.do", new JoinMember()); // 회원가입
		map.put("/checkIdAjax.do", new CheckId()); // 아이디 중복확인 아작스
		map.put("/loginForm.do", new LoginForm()); // 로그인 폼
		map.put("/loginMember.do", new LoginMember()); // 로그인
		map.put("/logout.do", new Logout()); // 로그아웃
		
		// 고객센터
		map.put("/noticeList.do", new NoticeList()); // 공지사항 목록
		map.put("/noticeForm.do", new NoticeForm()); // 공지사항 글쓰기폼
		
		map.put("/qnaList.do", new QnaList()); // qna 목록.jsp
		map.put("/qnaListAjax.do", new QnaListAjax()); // qna 목록 ajax		
		// 안준모의 테스트 컨트롤러
		map.put("/mocontrol.do", new Mo());
		map.put("/mocontrol2.do", new Mo2());
		map.put("/mocontrol3.do", new Mo3());
		map.put("/mocontrol4.do", new Mo4());
		map.put("/mocontrol5.do", new Mo5());
		map.put("/mocontrol6.do", new Mo6());
		map.put("/mocontrol7.do", new Mo7());
		map.put("/mocontrol8.do", new Mo8());
		map.put("/mocontrol9.do", new Mo9());
		map.put("/mocontrol10.do", new Mo10());
		// 김대운의 테스트 컨트롤러
		map.put("/woonControl.do", new Woon());	// 회원정보 변경 페이지
		map.put("/woonControl2.do", new Woon2());	// 회원정보 보여주기
		map.put("/woonControl3.do", new Woon3());	// 정보 변경
		map.put("/woonControl4.do", new Woon4());	// 주문 상태 페이지
		map.put("/woonControl5.do", new Woon5());	// 주문 처리
		map.put("/woonControl6.do", new Woon6());	// 찜 페이지
		map.put("/woonControl7.do", new Woon7());	// 찜 처리
		map.put("/woonControl8.do", new Woon8());	// 찜 삭제
		map.put("/woonControl9.do", new Woon9());	// 주문내역 상세 페이지
		map.put("/woonControl10.do", new Woon10());		// 상세 페이지 처리
		map.put("/woonControl11.do", new Woon11());		// 배송지 관리
		map.put("/woonControl12.do", new Woon12());		// 배송지 추가 처리
		map.put("/woonControl13.do", new Woon13());		// 배송지 변경 처리
		map.put("/woonControl14.do", new Woon14());		// 배송지 보여주기
		map.put("/woonControl15.do", new Woon15());	    // 현재 비밀번호 와 등록된 비밀 번호 확인
		map.put("/woonControl16.do", new Woon16());		// 모달창 처리
		map.put("/woonControl17.do", new Woon17());

		// 이상현의 테스트 컨트롤러
		map.put("/hyunControl.do", new Hyun()); // 상품리스트 페이지
		map.put("/hyunControl2.do", new Hyun2()); // 상품리스트 페이지 실행
		map.put("/hyunControl3.do", new Hyun3());
		map.put("/hyunControl4.do", new Hyun4());
		map.put("/hyunControl5.do", new Hyun5());
		map.put("/hyunControl6.do", new Hyun6());
		map.put("/hyunControl7.do", new Hyun7());
		map.put("/hyunControl8.do", new Hyun8());
		map.put("/hyunControl9.do", new Hyun9());
		map.put("/hyunControl10.do", new Hyun10());
		// 김지수의 테스트 컨트롤러
		map.put("/sooControl.do", new Soo());
		map.put("/sooControl2.do", new Soo2());
		map.put("/sooControl3.do", new Soo3());
		map.put("/sooControl4.do", new Soo4());
		map.put("/sooControl5.do", new Soo5());
		map.put("/sooControl6.do", new Soo6());
		map.put("/sooControl7.do", new Soo7());
		map.put("/sooControl8.do", new Soo8());
		map.put("/sooControl9.do", new Soo9());
		map.put("/sooControl10.do", new Soo10());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8"); // post일 경우.
		resp.setContentType("text/json;charset=UTF-8");
		String uri = req.getRequestURI(); // 서버정보를 뺀 url
		System.out.println("uri: " + uri); // /BoardWeb/main.do
		String context = req.getContextPath(); // project name => /BoardWeb
		System.out.println("context: " + context);
		String page = uri.substring(context.length());
		System.out.println("page: " + page);
		
		Control result = map.get(page);
		result.exec(req, resp);
		System.out.println("result: " + result);
	}
}
