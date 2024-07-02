package co.nambang.addr.service;

import java.util.List;

import co.nambang.addr.vo.AddrVO;

public interface AddrService {
	// 유저의 전체 배송지 조회
	public List<AddrVO> getSelectedAddr(String userId);
	
	// 배송지 추가
	public boolean addAddr(AddrVO avo);
	
	// 배송지 업데이트
	public boolean updateAddr(AddrVO avo);
	
}
