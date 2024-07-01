package co.nambang.qna.service;

import java.util.List;

import co.nambang.common.SearchVO;
import co.nambang.qna.vo.QnaVO;

public interface QnaService {

	List<QnaVO> qnaList(SearchVO search);

	int getTotalCnt();
	
}
