package co.nambang.zzim.mapper;

import java.util.List;

import co.nambang.zzim.vo.ZzimVO;


// 주문내역 테이블
public interface ZzimMapper {
	 List<ZzimVO> pickItems(String userId);
	 int pickDelete(int productCode);
}
