package co.nambang.detail.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.nambang.common.DataSource;
import co.nambang.detail.mapper.ProDetailMapper;
import co.nambang.detail.vo.ProDetailVO;
import co.nambang.hugi.vo.HugiVO;
import co.nambang.product.vo.ProductVO;
import co.nambang.zzim.vo.ZzimVO;

public class ProDetailServiceImpl implements ProDetailService{
	
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	ProDetailMapper mapper = sqlSession.getMapper(ProDetailMapper.class);
	
	@Override
	public List<ProductVO> detailList(String proCode) {
		return mapper.selectList(proCode);
	}
	@Override
	public boolean insZzim(String proCode, String userId) {
		return mapper.insertZzim(proCode, userId) == 1;
	}
	
	@Override
	public boolean insCart(int cartVolume, String unserId, String proCode) {
		return mapper.insertCart(cartVolume, unserId, proCode) == 1;
	}
	@Override
	public List<HugiVO> detailHugi(String proCode) {
		return mapper.hugiList(proCode);
	}
	@Override
	public boolean zzimSelect(String proCode,String userId) {
		return mapper.zzimList(proCode,userId) == 1;
	}

}
