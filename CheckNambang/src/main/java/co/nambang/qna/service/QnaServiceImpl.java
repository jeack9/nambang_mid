package co.nambang.qna.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.nambang.common.DataSource;
import co.nambang.notice.vo.NoticeVO;
import co.nambang.qna.mapper.QnaMapper;
import co.nambang.qna.vo.PageDTO;
import co.nambang.qna.vo.QnaVO;
import co.nambang.qna.vo.SearchVO;


public class QnaServiceImpl implements QnaService{
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	QnaMapper mapper = sqlSession.getMapper(QnaMapper.class);
	@Override
	public List<QnaVO> qnaList(SearchVO search) {
		return mapper.qnaList(search);
	}
	@Override
	public int getTotalCnt(SearchVO search) {
		return mapper.getTotalCnt(search);
	}
	
}
