import org.apache.ibatis.session.SqlSession;

import co.nambang.common.DataSource;
import co.nambang.detail.mapper.ProDetailMapper;
import co.nambang.member.mapper.MemberMapper;

public class AppTest {
	
	public static void main(String[] args) {
		SqlSession sqlSession = DataSource.getInstance().openSession(true);
//		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
//		System.out.println(mapper.selectMember("user01"));

	}
}
