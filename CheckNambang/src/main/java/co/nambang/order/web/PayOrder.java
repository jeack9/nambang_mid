package co.nambang.order.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.nambang.cart.service.CartService;
import co.nambang.cart.service.CartServiceImpl;
import co.nambang.common.Control;
import co.nambang.member.vo.MemberVO;
import co.nambang.odproduct.service.OdProductService;
import co.nambang.odproduct.service.OdProductServiceImpl;
import co.nambang.odproduct.vo.OdProductVO;
import co.nambang.order.service.OrderService;
import co.nambang.order.service.OrderServiceImpl;
import co.nambang.order.vo.OrderVO;

public class PayOrder implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		MemberVO login = (MemberVO) session.getAttribute("login");
		String userId = login == null ? "" : login.getUserId();
		
		String[] carts = req.getParameterValues("cartNo");
		String[] codes = req.getParameterValues("code");
		String[] volumes = req.getParameterValues("volume");
		String[] productPrice = req.getParameterValues("proPrice");
		String orderPrice = req.getParameter("orderPrice");
		String addrNo = req.getParameter("addrNo");
		String yocheong = req.getParameter("yocheong");
		//주문내역 정보 설정
		OrderVO ovo = new OrderVO();
		ovo.setAddrNo(Integer.parseInt(addrNo));
		ovo.setOrderPrice(Integer.parseInt(orderPrice));
		ovo.setOrderYocheong(yocheong);
		ovo.setUserId(userId);
		OrderService osvc = new OrderServiceImpl();
		
		int[] volumeArr = new int[volumes.length];
		int[] proPriceArr = new int[productPrice.length];
		int[] cartNoArr = new int[carts.length];
		// list컬렉션 or array
		OdProductVO[] arr = new OdProductVO[codes.length];
		OdProductService odpsvc = new OdProductServiceImpl();
		if(osvc.addOrder(ovo)) { // 주문내역 등록 -> 상세 주문 내역 등록
			for(int i = 0; i < codes.length; i++) {
				volumeArr[i] = Integer.parseInt(volumes[i]);
				proPriceArr[i] = Integer.parseInt(productPrice[i]);
				cartNoArr[i] = Integer.parseInt(carts[i]);
						
				OdProductVO odp = new OdProductVO();
				odp.setProductCode(codes[i]);
				odp.setOpVolume(volumeArr[i]);
				odp.setOpPrice(proPriceArr[i]);
				odp.setUserId(userId);
				odp.setOrderNo(ovo.getOrderNo());
				arr[i] = odp;
			}
			int cnt = odpsvc.addOdProducts(arr);
			if(cnt > 0) { //주문 상세 등록 -> 해당 카트 삭제
				//System.out.println(cnt + "추가");
				CartService csvc = new CartServiceImpl();
				if(csvc.delCarts(cartNoArr)) {
					req.setAttribute("msg", cnt + "개의 상품주문을 완료하였습니다.");
					req.getRequestDispatcher("main.do").forward(req, resp);
				}else {
					req.setAttribute("msg", "결제에 실패하였습니다.");
					req.getRequestDispatcher("cartList.do").forward(req, resp);
				}
			}
			
		}
	}

}
