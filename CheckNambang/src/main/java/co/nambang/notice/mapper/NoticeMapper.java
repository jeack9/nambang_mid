package co.nambang.notice.mapper;

import java.util.List;

import co.nambang.notice.vo.NoticeVO;

public interface NoticeMapper {
    //공지사항 목록
	List<NoticeVO> selectList();
	//추가
    boolean addNotion(NoticeVO bvo);
    //삭제
    boolean removeNotion(NoticeVO bvo);
}
