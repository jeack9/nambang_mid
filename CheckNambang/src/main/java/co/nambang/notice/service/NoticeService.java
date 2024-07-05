package co.nambang.notice.service;

import java.util.List;

import co.nambang.notice.vo.NoticeVO;

public interface NoticeService {
	List<NoticeVO> noticelist();
	NoticeVO selectNotice(int noticeNo);

	//json
	List<NoticeVO> noticeList2(int noticeNo);
}
