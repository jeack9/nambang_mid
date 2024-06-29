package co.nambang.addr.mapper;

import org.apache.ibatis.annotations.Param;

import co.nambang.addr.vo.AddrVO;

public interface AddrMapper {
	public int insertAddr(AddrVO avo);
	public AddrVO selectAddr(@Param(value = "uid") String uid, @Param(value = "selected") int selected);
}
