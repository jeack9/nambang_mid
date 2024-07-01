package co.nambang.notice.mapper;

import java.util.List;

import co.nambang.common.SearchVO;
import co.nambang.notice.vo.NoticeVO;

public interface NoticeMapper {
	public List<NoticeVO> noticeList(SearchVO search);
	public int getTotalCnt(); 
}
