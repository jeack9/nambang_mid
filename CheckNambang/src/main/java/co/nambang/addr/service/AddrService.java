package co.nambang.addr.service;

import co.nambang.addr.vo.AddrVO;

public interface AddrService {
	// 특정 유저 기본 배송지 조회
	public AddrVO getSelectedAddr(String userId, int addrSelected);
	
	// 배송지 추가
	public boolean addAddr(AddrVO avo);
}
