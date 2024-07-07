package co.nambang.addr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.nambang.addr.vo.AddrVO;

public interface AddrMapper {
	public int insertAddr(AddrVO avo);
	public List<AddrVO> selectAddr(String userId);
	public int updateAddr(AddrVO avo);
	
	public int basicAddr(String userId);
	public int changeAddr(AddrVO avo);
	
	public AddrVO getAddrPick(String userId);
}
