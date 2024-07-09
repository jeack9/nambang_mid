package co.nambang.zzim.service;

import java.util.List;

import co.nambang.zzim.vo.ZzimVO;


public interface ZzimService {
	List<ZzimVO> zzimItems(String userId);
	boolean deleteZzimItems(String zzimNo);
	int zzimCnt(String userId);
}
