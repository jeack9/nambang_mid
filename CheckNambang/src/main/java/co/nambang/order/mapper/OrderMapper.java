package co.nambang.order.mapper;

import java.util.List;
import java.util.Map;

import co.nambang.order.vo.OrderVO;

// 주문내역 테이블
public interface OrderMapper {
	public int insertOrder(OrderVO ovo);
	
	public List<Map<String, Object>> orderHistroyList(String userId);
}
