package co.nambang.qna.service;

import java.util.List;

import co.nambang.qna.vo.PageDTO;
import co.nambang.qna.vo.QnaVO;
import co.nambang.qna.vo.SearchVO;

public interface QnaService {

	List<QnaVO> qnaList(SearchVO search);

	int getTotalCnt();
	
}
