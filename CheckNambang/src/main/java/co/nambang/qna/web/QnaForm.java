package co.nambang.qna.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.nambang.common.Control;
import co.nambang.member.vo.MemberVO;
import co.nambang.order.service.OrderService;
import co.nambang.order.service.OrderServiceImpl;

public class QnaForm implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 상품선택 모달창 주문상품 정보 전달
		OrderService osvc = new OrderServiceImpl();
		HttpSession session = req.getSession();
		MemberVO login = (MemberVO)session.getAttribute("login");
		String userId = login == null ? "" : login.getUserId();
		List<Map<String, Object>> historyList = osvc.orderHistroyList(userId);
		req.setAttribute("list", historyList);
	
		req.getRequestDispatcher("board/qnaForm.tiles").forward(req, resp);
	}

}
