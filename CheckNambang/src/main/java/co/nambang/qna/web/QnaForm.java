package co.nambang.qna.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.nambang.common.Control;
import co.nambang.member.vo.MemberVO;
import co.nambang.odproduct.vo.OdProductVO;
import co.nambang.order.service.OrderService;
import co.nambang.order.service.OrderServiceImpl;

public class QnaForm implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 상품선택 모달창 주문상품 정보 전달
		OrderService osvc = new OrderServiceImpl();
		HttpSession session = req.getSession();
		MemberVO login = (MemberVO) session.getAttribute("login");
		String userId = login == null ? "" : login.getUserId();
		List<Map<Object, Object>> historyList = osvc.orderHistroyList(userId);
		
		// { 'order1': [{detail1, detail2}], 'order2': [{detail3}], 'order3': 
		// order1 - detail1
					// order1 - detail2
					// order2 - detail3
					// order3 - detail4
					// order3 - detail5
					// order1 - detail1 [0]
					//        - detail2 [1]
					// order2 - 
		Map<Object, List<OdProductVO>> target = new HashMap<Object, List<OdProductVO>>();
		historyList.forEach(history ->{
			System.out.println(history);
			System.out.println("hhhhh");
			Object key = history.get("order_no");
			if(!target.containsKey(key)) {
				OdProductVO odp = new OdProductVO();
				odp.setProductImage(((String) history.get("product_image")));
				odp.setCompany((String) history.get("company"));
				odp.setProductName((String)history.get("product_name"));
				odp.setOpVolume1((String) history.get("op_volume"));
				odp.setOpPrice1((String) history.get("op_price"));
				odp.setOrderDate((Date)history.get("order_date"));
				
				List<OdProductVO> list = new ArrayList<OdProductVO>();
				list.add(odp);
				target.put(key, list);
			}else {
				OdProductVO odp = new OdProductVO();
				odp.setProductImage(((String) history.get("product_image")));
				odp.setCompany((String) history.get("company"));
				odp.setProductName((String)history.get("product_name"));
				odp.setOpVolume1((String) history.get("op_volume"));
				odp.setOpPrice1((String) history.get("op_price"));
				odp.setOrderDate((Date)history.get("order_date"));
				
				List<OdProductVO> list = target.get(key);
				list.add(odp);
			}
		}); // historyList.forEach END
		req.setAttribute("map", target);
		
		req.getRequestDispatcher("board/qnaForm.tiles").forward(req, resp);
	}

}
