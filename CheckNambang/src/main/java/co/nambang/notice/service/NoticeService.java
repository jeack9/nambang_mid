package co.nambang.notice.service;

import java.util.List;

import co.nambang.common.SearchVO;
import co.nambang.notice.vo.NoticeVO;

public interface NoticeService {
	public List<NoticeVO> noticeList(SearchVO search);
	public int getTotalCnt();
}
