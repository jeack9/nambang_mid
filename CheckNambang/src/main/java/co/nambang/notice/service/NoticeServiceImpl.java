package co.nambang.notice.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.nambang.common.DataSource;
import co.nambang.notice.mapper.NoticeMapper;
import co.nambang.notice.vo.NoticeVO;

public class NoticeServiceImpl implements NoticeService {
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	NoticeMapper mapper = sqlSession.getMapper(NoticeMapper.class);

	@Override
	public List<NoticeVO> noticelist() {
		// TODO Auto-generated method stub
		return mapper.selectList();
	}

	@Override
	public NoticeVO selectNotice(int noticeNo) {
		// TODO Auto-generated method stub
		return mapper.selectNotice(noticeNo);
	}

	@Override
	public List<NoticeVO> noticeList2(int noticeNo) {
		// TODO json
		return mapper.selectList2(noticeNo);
	}

	@Override
	public List<NoticeVO> pagingNotice(int page) {
		// TODO Auto-generated method stub
		return mapper.pagingNotice(page);
	}

	@Override
	public int pagingNo() {
		return mapper.pagingNo();
	}

}
