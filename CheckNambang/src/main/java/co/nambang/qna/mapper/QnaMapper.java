package co.nambang.qna.mapper;

import java.util.List;

import co.nambang.qna.vo.QnaVO;
import co.nambang.qna.vo.SearchVO;

// 주문내역 테이블
public interface QnaMapper {
	public int getTotalCnt();
	public List<QnaVO> qnaList(SearchVO search);
}
