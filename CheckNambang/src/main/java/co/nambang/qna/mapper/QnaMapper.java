package co.nambang.qna.mapper;

import java.util.List;

import co.nambang.common.SearchVO;
import co.nambang.qna.vo.QnaVO;

// 주문내역 테이블
public interface QnaMapper {
	public int getTotalCnt();
	public List<QnaVO> qnaList(SearchVO search);
}
