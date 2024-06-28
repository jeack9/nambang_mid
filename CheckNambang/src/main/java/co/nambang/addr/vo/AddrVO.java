package co.nambang.addr.vo;

import lombok.Data;

@Data
public class AddrVO {
	private int addrNo;
	private String addr1;
	private String addr2;
	private String getter; // 받는 사람
	private String getterPhone;
	private String userId;
	private int addrSelected;
}
