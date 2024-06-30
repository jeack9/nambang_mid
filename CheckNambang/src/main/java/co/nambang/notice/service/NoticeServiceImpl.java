package co.nambang.notice.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.nambang.common.DataSource;
import co.nambang.notice.mapper.NoticeMapper;
import co.nambang.notice.vo.NoticeVO;


public class NoticeServiceImpl implements NoticeService{
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	NoticeMapper mapper = sqlSession.getMapper(NoticeMapper.class);
	
	@Override
	public List<NoticeVO> noticeList(int page) {
		return mapper.noticeList(page);
	}

	@Override
	public int getTotalCnt() {
		return mapper.getTotalCnt();
	}
	
}
