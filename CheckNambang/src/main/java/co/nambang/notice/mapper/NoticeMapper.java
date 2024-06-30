package co.nambang.notice.mapper;

import java.util.List;

import co.nambang.notice.vo.NoticeVO;

public interface NoticeMapper {
	public List<NoticeVO> noticeList(int page);
	public int getTotalCnt(); 
}
