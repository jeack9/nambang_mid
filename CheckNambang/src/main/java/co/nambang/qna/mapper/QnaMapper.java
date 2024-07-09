package co.nambang.qna.mapper;

import java.util.List;

import co.nambang.qna.vo.QnaVO;
import co.nambang.qna.vo.SearchVO;

// 주문내역 테이블
public interface QnaMapper {
	public int getTotalCnt(SearchVO search); // qna 페이징용
	public List<QnaVO> qnaList(SearchVO search); // qna 목록
	public List<String> type2List(String type1); // 문의폼 상세유형 종류
	public int registerQna(QnaVO qvo); // 글등록
	public QnaVO getQna(int no); // qna 단건 조회
	public int removeQna(int no); // qna 삭제
}
