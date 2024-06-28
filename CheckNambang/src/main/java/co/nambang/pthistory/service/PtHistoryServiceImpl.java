package co.nambang.pthistory.service;

import org.apache.ibatis.session.SqlSession;

import co.nambang.common.DataSource;
import co.nambang.pthistory.mapper.PtHistoryMapper;


public class PtHistoryServiceImpl implements PtHistoryService{
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	PtHistoryMapper mapper = sqlSession.getMapper(PtHistoryMapper.class);
	
}
