package co.nambang.notice.service;

import org.apache.ibatis.session.SqlSession;

import co.nambang.common.DataSource;
import co.nambang.notice.mapper.NoticeMapper;


public class NoticeServiceImpl implements NoticeService{
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	NoticeMapper mapper = sqlSession.getMapper(NoticeMapper.class);
	
}
