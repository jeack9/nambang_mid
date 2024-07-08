package co.nambang.order.service;

import java.util.List;
import java.util.Map;

import co.nambang.order.vo.OrderVO;

public interface OrderService {
	public boolean addOrder(OrderVO ovo);
	
	public List<Map<String, Object>> orderHistroyList(String userId);
}
