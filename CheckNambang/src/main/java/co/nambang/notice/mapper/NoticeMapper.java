package co.nambang.notice.mapper;

import java.util.List;

import co.nambang.notice.vo.NoticeVO;

public interface NoticeMapper {
    //공지사항 목록
	List<NoticeVO> selectList();
    //공지사항 한개 선택
    NoticeVO selectNotice(int noticeNo);
    // 목록 json
    List<NoticeVO> selectList2(int noticeNo);
    //추가
    boolean addNotice(NoticeVO bvo);
    //삭제
    boolean removeNotice(NoticeVO bvo);
    //공지사항 페이징
    List<NoticeVO> pagingNotice(int page);
    //페이지 갯수
    int pagingNo();
}
