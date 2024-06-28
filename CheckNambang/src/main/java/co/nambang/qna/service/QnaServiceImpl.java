package co.nambang.qna.service;

import org.apache.ibatis.session.SqlSession;

import co.nambang.common.DataSource;
import co.nambang.qna.mapper.QnaMapper;


public class QnaServiceImpl implements QnaService{
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	QnaMapper mapper = sqlSession.getMapper(QnaMapper.class);
	
}
