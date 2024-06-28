package co.nambang.reply.service;

import org.apache.ibatis.session.SqlSession;

import co.nambang.common.DataSource;
import co.nambang.reply.mapper.ReplyMapper;


public class ReplyServiceImpl implements ReplyService{
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);
	
}
