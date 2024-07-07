package co.nambang.detail.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.nambang.detail.vo.ProDetailVO;
import co.nambang.hugi.vo.HugiVO;
import co.nambang.product.vo.ProductVO;
import co.nambang.zzim.vo.ZzimVO;

public interface ProDetailMapper {
	List<ProductVO> selectList(String proCode);
	
	int insertZzim(@Param("proCode")String proCode, @Param("userId")String userId);
	
	int insertCart(@Param("cartVolume")int cartVolume,@Param("userId")String userId,@Param("proCode")String proCode );
	
	List<HugiVO> hugiList(String proCode);
	List<HugiVO> hugiPaging(@Param("proCode") String proCode, @Param("page") int page);
	
	int zzimList(@Param("proCode")String proCode,@Param("userId")String userId);
	
	int hugiCnt(String proCode);

}
