import java.util.List;

import co.nambang.notice.service.NoticeService;
import co.nambang.notice.service.NoticeServiceImpl;
import co.nambang.notice.vo.NoticeVO;

public class AppTest {

	public static void main(String[] args) {
		NoticeService svc = new NoticeServiceImpl();

		List<NoticeVO> list1 = svc.noticelist();

		for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i));
		}
	}
}
