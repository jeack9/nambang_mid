package co.nambang.order.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.nambang.common.Control;
import co.nambang.order.service.OrderService;
import co.nambang.order.service.OrderServiceImpl;
import co.nambang.order.vo.OrderVO;

public class PayOrder implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] codes = req.getParameterValues("code");
		String[] volumes = req.getParameterValues("volume");
		String[] productPrice = req.getParameterValues("proPrice");
		String orderPrice = req.getParameter("orderPrice");
		String addrNo = req.getParameter("addrNo");
		String yocheong = req.getParameter("yocheong");
		OrderVO ovo = new OrderVO();
		ovo.setAddrNo(Integer.parseInt(addrNo));
		ovo.setOrderPrice(Integer.parseInt(orderPrice));
		ovo.setOrderYocheong(yocheong);
		OrderService osvc = new OrderServiceImpl();
		
		int[] codeArr = new int[codes.length];
		int[] volumeArr = new int[volumes.length];
		int[] proPriceArr = new int[productPrice.length];
		// list컬렉션 or array 
		if(osvc.addOrder(ovo)) {
			for(int i = 0; i < codes.length; i++) {
				codeArr[i] = Integer.parseInt(codes[i]);
				volumeArr[i] = Integer.parseInt(volumes[i]);
				proPriceArr[i] = Integer.parseInt(productPrice[i]);
			}
		}
	}

}
