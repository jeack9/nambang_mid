package co.nambang.notice.service;

import java.util.List;

import co.nambang.notice.vo.NoticeVO;

public interface NoticeService {
	List<NoticeVO> noticelist();
	NoticeVO selectNotice(int noticeNo);
	//json
	List<NoticeVO> noticeList2(int noticeNo);
	//페이징
	List<NoticeVO> pagingNotice(int page);
	//페이지 갯수
	int pagingNo();
	//게시글 등록
	boolean addNotice(NoticeVO bvo);
}
