import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import co.nambang.cart.mapper.CartMapper;
import co.nambang.common.DataSource;
import co.nambang.notice.service.NoticeService;
import co.nambang.notice.service.NoticeServiceImpl;
import co.nambang.notice.vo.NoticeVO;

public class AppTest {

	public static void main(String[] args) {
		SqlSession sqlSession = DataSource.getInstance().openSession(true);
		CartMapper mapper = sqlSession.getMapper(CartMapper.class);
		
		List<Map<String, Object>> list = mapper.cartList("user01");
		System.out.println(list.get(0).keySet());
	}
}
