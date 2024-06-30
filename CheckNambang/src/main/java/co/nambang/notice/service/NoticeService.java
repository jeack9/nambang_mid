package co.nambang.notice.service;

import java.util.List;

import co.nambang.notice.vo.NoticeVO;

public interface NoticeService {
	public List<NoticeVO> noticeList(int page);
	public int getTotalCnt();
}
