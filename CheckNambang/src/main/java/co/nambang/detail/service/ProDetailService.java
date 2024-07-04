package co.nambang.detail.service;

import java.util.List;

import co.nambang.detail.vo.ProDetailVO;
import co.nambang.hugi.vo.HugiVO;
import co.nambang.product.vo.ProductVO;
import co.nambang.zzim.vo.ZzimVO;

public interface ProDetailService {
	List<ProductVO> detailList(String proCode);
	
	boolean insZzim(String proCode, String userId);
	
	boolean insCart(int cartVolume, String unserId, String proCode);
	
	List<HugiVO> detailHugi(String proCode);
	 
	boolean zzimSelect(String proCode,String userId);

}
